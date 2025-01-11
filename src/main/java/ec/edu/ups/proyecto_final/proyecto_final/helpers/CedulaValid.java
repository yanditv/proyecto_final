package ec.edu.ups.proyecto_final.proyecto_final.helpers;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CedulaValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CedulaValid {

    String message() default "La cédula no es válida.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
