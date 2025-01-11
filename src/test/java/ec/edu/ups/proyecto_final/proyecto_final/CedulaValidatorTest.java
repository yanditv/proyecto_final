package ec.edu.ups.proyecto_final.proyecto_final;

import ec.edu.ups.proyecto_final.proyecto_final.helpers.CedulaValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CedulaValidatorTest {

    private final CedulaValidator cedulaValidator = new CedulaValidator();

    @Test
    public void testCedulaValida() {
        String cedulaValida = "1900896968"; // Cedula de ejemplo válida
        assertTrue(cedulaValidator.isValid(cedulaValida, null), "La cédula debe ser válida.");
    }

    @Test
    public void testCedulaInvalidaPorFormatoIncorrecto() {
        String cedulaInvalida = "06017779"; // Menos de 10 dígitos
        assertFalse(cedulaValidator.isValid(cedulaInvalida, null), "La cédula debe ser inválida.");
    }

    @Test
    public void testCedulaInvalidaPorProvinciaIncorrecta() {
        String cedulaInvalida = "2501777989"; // Provincia incorrecta (el rango es 01-24)
        assertFalse(cedulaValidator.isValid(cedulaInvalida, null), "La cédula debe ser inválida.");
    }

    @Test
    public void testCedulaInvalidaPorTercerDigitoIncorrecto() {
        String cedulaInvalida = "1970896968"; // El tercer dígito debe ser menor que 6
        assertFalse(cedulaValidator.isValid(cedulaInvalida, null), "La cédula debe ser inválida.");
    }

    @Test
    public void testCedulaInvalidaPorDigitoVerificadorIncorrecto() {
        String cedulaInvalida = "1900896967"; // El dígito verificador está mal
        assertFalse(cedulaValidator.isValid(cedulaInvalida, null), "La cédula debe ser inválida.");
    }

    @Test
    public void testCedulaNula() {
        String cedulaNula = null;
        assertFalse(cedulaValidator.isValid(cedulaNula, null), "La cédula nula debe ser inválida.");
    }

    @Test
    public void testCedulaConCaracteresNoNumericos() {
        String cedulaInvalida = "0601a77989"; // Cedula con caracteres no numéricos
        assertFalse(cedulaValidator.isValid(cedulaInvalida, null),
                "La cédula con caracteres no numéricos debe ser inválida.");
    }
}