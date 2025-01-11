package ec.edu.ups.proyecto_final.proyecto_final.helpers;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CedulaValidator implements ConstraintValidator<CedulaValid, String> {

    @Override
    public boolean isValid(String cedula, ConstraintValidatorContext context) {
        if (cedula == null || !cedula.matches("\\d{10}"))
            return false;

        int[] coeficientes = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
        int suma = 0;
        int provincia = Integer.parseInt(cedula.substring(0, 2));
        int tercerDigito = Character.getNumericValue(cedula.charAt(2));

        if (provincia < 1 || provincia > 24 || tercerDigito >= 6)
            return false;

        for (int i = 0; i < coeficientes.length; i++) {
            int producto = coeficientes[i] * Character.getNumericValue(cedula.charAt(i));
            suma += producto >= 10 ? producto - 9 : producto;
        }

        int digitoVerificador = (10 - (suma % 10)) % 10;
        return digitoVerificador == Character.getNumericValue(cedula.charAt(9));
    }
}
