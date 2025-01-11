package ec.edu.ups.proyecto_final.proyecto_final.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import ec.edu.ups.proyecto_final.proyecto_final.helpers.CedulaValid;
import jakarta.validation.constraints.*;

@Document(collection = "clientes") // Indica que esta clase representa un documento de MongoDB
@Data
@NoArgsConstructor
@AllArgsConstructor
public class cliente {

    @Id // Identificador único en MongoDB
    private String id;

    @NotBlank(message = "El campo 'nombres' es obligatorio.")
    private String nombres;

    @NotBlank(message = "El campo 'apellidos' es obligatorio.")
    private String apellidos;

    @Indexed(unique = true) // Crea un índice único en MongoDB para este campo
    @CedulaValid
    private String cedula;

    @NotBlank(message = "El campo 'correo' es obligatorio.")
    @Email(message = "El correo electrónico no es válido.")
    private String correo;

    @NotBlank(message = "El campo 'telefono' es obligatorio.")
    @Pattern(regexp = "\\d{10}", message = "El teléfono debe contener exactamente 10 dígitos.")
    private String telefono;

    @NotNull(message = "El campo 'fechaNacimiento' es obligatorio.")
    private String fechaNacimiento;
}