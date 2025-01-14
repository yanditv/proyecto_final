package ec.edu.ups.proyecto_final.proyecto_final;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.mockito.Mock;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;

import ec.edu.ups.proyecto_final.proyecto_final.controllers.ClienteController;
// import ec.edu.ups.proyecto_final.proyecto_final.repository.ClienteRepository;

// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(ClienteController.class)
@AutoConfigureMockMvc

public class ClienteControllerTest {
        /*
         * @Autowired
         * private MockMvc mockMvc;
         * 
         * @Mock
         * private ClienteRepository clienteRepository;
         * 
         * @Test
         * public void testCrearClienteConApiKeyValida() throws Exception {
         * String clienteJson = "{\n" +
         * "  \"nombres\": \"Juan\",\n" +
         * "  \"apellidos\": \"Pérez\",\n" +
         * "  \"cedula\": \"0601777989\",\n" +
         * "  \"correo\": \"juan.perez@example.com\",\n" +
         * "  \"telefono\": \"3919059839\",\n" +
         * "  \"fechaNacimiento\": \"1990-01-01\"\n" +
         * "}";
         * 
         * mockMvc.perform(post("/api/clientes")
         * .header("x-api-key", "mi-api-key") // API key válida
         * .contentType(MediaType.APPLICATION_JSON)
         * .content(clienteJson))
         * .andExpect(status().isOk())
         * .andExpect(jsonPath("$.ok").value(true))
         * .andExpect(jsonPath("$.message").value("Cliente creado correctamente"));
         * }
         */
        // @Test
        // public void testCrearClienteConApiKeyInvalida() throws Exception {
        // String clienteJson = "{\n" +
        // " \"nombres\": \"Juan\",\n" +
        // " \"apellidos\": \"Pérez\",\n" +
        // " \"cedula\": \"0601777989\",\n" +
        // " \"correo\": \"juan.perez@example.com\",\n" +
        // " \"telefono\": \"3919059839\",\n" +
        // " \"fechaNacimiento\": \"1990-01-01\"\n" +
        // "}";

        // mockMvc.perform(post("/api/clientes")
        // .header("x-api-key", "invalid-api-key") // API key incorrecta
        // .contentType(MediaType.APPLICATION_JSON)
        // .content(clienteJson))
        // .andExpect(status().isForbidden()) // 403 Forbidden
        // .andExpect(jsonPath("$.ok").value(false))
        // .andExpect(jsonPath("$.message").value("API key no válida"));
        // }
}
