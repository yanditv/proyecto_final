package ec.edu.ups.proyecto_final.proyecto_final.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ec.edu.ups.proyecto_final.proyecto_final.helpers.ApiResponse;
import ec.edu.ups.proyecto_final.proyecto_final.models.cliente;
import ec.edu.ups.proyecto_final.proyecto_final.repository.ClienteRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@Tag(name = "Clientes", description = "API de Clientes")
@SecurityRequirement(name = "x-api-key")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    @Operation(summary = "Obtener lista de clientes", security = @SecurityRequirement(name = "ApiKeyAuth"))
    public ResponseEntity<ApiResponse<List<cliente>>> obtenerClientes() {
        List<cliente> clientes = clienteRepository.findAll();

        ApiResponse<List<cliente>> response = new ApiResponse<>(true, null, clientes, HttpStatus.OK.value());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    @Operation(summary = "Registrar un cliente", security = @SecurityRequirement(name = "ApiKeyAuth"))
    public ResponseEntity<ApiResponse<?>> crearCliente(@Valid @RequestBody cliente cliente) {
        cliente nuevoCliente = clienteRepository.save(cliente);
        ApiResponse<cliente> response = new ApiResponse<>(
                true,
                null,
                nuevoCliente,
                HttpStatus.OK.value());
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un cliente", security = @SecurityRequirement(name = "ApiKeyAuth"))
    public ResponseEntity<ApiResponse<?>> actualizarCliente(
            @PathVariable String id, @Valid @RequestBody cliente clienteActualizado) {

        cliente cliente = clienteRepository.findById(id)
                .map(clienteEncontrado -> {
                    clienteEncontrado.setNombres(clienteActualizado.getNombres());
                    clienteEncontrado.setApellidos(clienteActualizado.getApellidos());
                    clienteEncontrado.setCedula(clienteActualizado.getCedula());
                    clienteEncontrado.setCorreo(clienteActualizado.getCorreo());
                    clienteEncontrado.setTelefono(clienteActualizado.getTelefono());
                    clienteEncontrado.setFechaNacimiento(clienteActualizado.getFechaNacimiento());
                    clienteRepository.save(clienteEncontrado);
                    return clienteEncontrado;
                })
                .orElse(null);

        if (cliente == null) {
            ApiResponse<String> response = new ApiResponse<>(false, "Cliente no encontrado", null,
                    HttpStatus.NOT_FOUND.value());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        ApiResponse<cliente> response = new ApiResponse<>(
                true,
                null,
                cliente,
                HttpStatus.OK.value());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un cliente", security = @SecurityRequirement(name = "ApiKeyAuth"))
    public ResponseEntity<ApiResponse<String>> eliminarCliente(@PathVariable String id) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    clienteRepository.delete(cliente);
                    ApiResponse<String> response = new ApiResponse<>(true, "Cliente eliminado", null,
                            HttpStatus.NO_CONTENT.value());
                    return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
                })
                .orElseGet(() -> {
                    ApiResponse<String> response = new ApiResponse<>(false, "Cliente no encontrado", null,
                            HttpStatus.NOT_FOUND.value());
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
                });
    }
}