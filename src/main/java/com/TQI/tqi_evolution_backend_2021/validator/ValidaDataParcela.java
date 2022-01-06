package com.TQI.tqi_evolution_backend_2021.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ValidaDataParcela implements ConstraintValidator<dataParcelaIsValid, String> {

    @Override
    public void initialize(dataParcelaIsValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var dataLimite = LocalDate.now().plusMonths(3);
        var dataUSer = LocalDate.now();
        var dataAtual = LocalDate.now();

        try{
            dataUSer = LocalDate.parse(s, formatoData);
        }
        catch (Exception e){
            return false;
        }

        if(dataUSer.isAfter(dataLimite))
            return false;

        if(dataUSer.isBefore(dataAtual))
            return false;

        return true;
    }
}
