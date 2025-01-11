package ec.edu.ups.proyecto_final.proyecto_final.config;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/*") // Aplica el filtro a todas las rutas de la API
public class ApiKeyAuthFilter implements Filter {

    private final ApiKeyProvider apiKeyProvider;

    // Constructor para inyectar ApiKeyProvider
    public ApiKeyAuthFilter(ApiKeyProvider apiKeyProvider) {
        this.apiKeyProvider = apiKeyProvider;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // No es necesario inicializar nada en este caso
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Obtener la API Key desde los encabezados de la solicitud
        String apiKey = httpRequest.getHeader("x-api-key");
        System.out.println(apiKey);

        String validApiKey = apiKeyProvider.getApiKey();
        System.out.println(validApiKey);
        // Validar si la API Key está presente y es correcta
        if (apiKey == null || !apiKey.equals(validApiKey)) {
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 Unauthorized
            httpResponse.getWriter().write("{\"error\": \"Acceso no autorizado: falta o es incorrecta la API Key.\"}");
            return; // Detener la ejecución de la solicitud si la validación falla
        }

        // Si la clave es válida, permitir que la solicitud continúe
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // No es necesario destruir nada en este caso
    }
}