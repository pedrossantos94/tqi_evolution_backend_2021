package com.TQI.tqi_evolution_backend_2021.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ValidaData.class)

public @interface dataIsValid {

    String message() default "A data informada é inválida!";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

}