package co.com.bancolombia.model.persona.gateways;

import co.com.bancolombia.model.persona.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository {
    List<Persona> listAllPersona();
    Persona getPersona(String id);

    void createPersona(Persona persona);
    Persona updatePersona(Persona persona);
    void deletePersona(String id);
    }
