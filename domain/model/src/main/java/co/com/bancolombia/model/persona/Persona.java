package co.com.bancolombia.model.persona;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Persona {
    private String id;
    private String Nombre;
    private String Apellido;


}
