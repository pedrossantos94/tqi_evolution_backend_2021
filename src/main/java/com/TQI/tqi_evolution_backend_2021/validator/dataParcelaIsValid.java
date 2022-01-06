package com.TQI.tqi_evolution_backend_2021.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ValidaDataParcela.class)

public @interface dataParcelaIsValid {

    String message() default "Data da primeira parcela deve ser de até 3 meses a partir da data atual.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}