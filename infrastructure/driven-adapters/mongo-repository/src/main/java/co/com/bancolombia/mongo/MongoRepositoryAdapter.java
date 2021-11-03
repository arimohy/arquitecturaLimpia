package co.com.bancolombia.mongo;

import co.com.bancolombia.model.persona.Persona;
import co.com.bancolombia.model.persona.gateways.PersonaRepository;
import co.com.bancolombia.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MongoRepositoryAdapter extends AdapterOperations<Persona, Persona, String, MongoDBRepository> implements PersonaRepository
{

    public MongoRepositoryAdapter(MongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Persona.class));
    }

    @Override
    public List<Persona> listAllPersona() {
        return this.repository.findAll();
    }

    @Override
    public Persona getPersona(String id) {
        return this.findById(id);
    }

    @Override
    public void createPersona(Persona persona) {
        this.repository.save(persona);
    }

    @Override
    public Persona updatePersona(Persona persona) {
        return this.repository.save(persona);
    }

    @Override
    public void deletePersona(String id) {
        this.repository.deleteById(id);

    }
}
