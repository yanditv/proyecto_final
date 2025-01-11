package ec.edu.ups.proyecto_final.proyecto_final.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Proyecto Final", version = "1.0", description = "API de clientes"))
// @SecurityScheme(name = "apiKey", type = SecuritySchemeType.APIKEY, in =
// SecuritySchemeIn.HEADER, paramName = "x-api-key")
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("ApiKeyAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.APIKEY)
                                .in(SecurityScheme.In.HEADER)
                                .name("x-api-key")))
                .addSecurityItem(new SecurityRequirement().addList("ApiKeyAuth"));
    }
}
