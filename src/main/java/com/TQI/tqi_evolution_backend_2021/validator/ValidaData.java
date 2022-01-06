package com.TQI.tqi_evolution_backend_2021.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ValidaData implements ConstraintValidator<dataIsValid, String> {

    @Override
    public void initialize(dataIsValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var data = LocalDate.now();

        try{
            data = LocalDate.parse(s,formatoData);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}