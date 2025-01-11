package ec.edu.ups.proyecto_final.proyecto_final.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApiKeyProvider {

    @Value("${api.key}") // Carga la API Key desde application.properties
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }
}