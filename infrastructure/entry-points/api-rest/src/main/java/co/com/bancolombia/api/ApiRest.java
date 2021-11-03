package co.com.bancolombia.api;
import co.com.bancolombia.model.persona.Persona;
import co.com.bancolombia.usecase.persona.PersonaUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final PersonaUseCase useCase;

    @PostMapping("/save")
    public String save(@RequestBody Persona persona){
        useCase.createPersona(persona);
        return "Persona creada";
    }

    @GetMapping("/get")
    public List<Persona> findAll() {
        return useCase.listAllPersona();
    }

    @GetMapping("/get/{id}")
    public Persona finduser(@PathVariable(value = "id") String id) {
        return useCase.getPersona(id);
    }

    @PostMapping("/update/{id}")
    public String update(@RequestBody Persona persona){
        useCase.updatePersona(persona);
        return "Persona actualizada";
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Persona> edit(@RequestBody Persona persona){
        if(!persona.getId().isEmpty()){
            return new ResponseEntity(useCase.updatePersona(persona), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") String id){
        useCase.deletePersona(id);
        return "Persona fue eliminada";
    }
}
