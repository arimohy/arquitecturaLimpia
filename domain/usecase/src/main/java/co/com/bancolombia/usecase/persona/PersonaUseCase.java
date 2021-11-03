package co.com.bancolombia.usecase.persona;

import co.com.bancolombia.model.persona.Persona;
import co.com.bancolombia.model.persona.gateways.PersonaRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class PersonaUseCase {
    private final PersonaRepository iPersonaRepository;

    public List<Persona> listAllPersona(){
        List<Persona> personas = new ArrayList<>();
        personas = iPersonaRepository.listAllPersona();
        return personas;
    }

    public Persona getPersona(String id) {
        Persona persona =  iPersonaRepository.getPersona(id);
        return persona;
    }

    public void createPersona(Persona persona) {
        iPersonaRepository.createPersona(persona);
    }

    public Persona updatePersona(Persona persona) {
        Persona productUpdate = iPersonaRepository.updatePersona(persona);
        return productUpdate;
    }

    public  void deletePersona(String id) {
        iPersonaRepository.deletePersona(id);
    }

}
