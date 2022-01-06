package com.TQI.tqi_evolution_backend_2021.validator;

import com.TQI.tqi_evolution_backend_2021.model.Cliente;
import com.TQI.tqi_evolution_backend_2021.repository.CadastroUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidaEmail  implements ConstraintValidator<emailIsValid, String> {

    @Autowired
    CadastroUsuarioRepository cadastroUsuarioRepository;

    @Override
    public void initialize(emailIsValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean flag = false;
        var listaUsuarios = cadastroUsuarioRepository.findAll();

        for(Cliente usuario : listaUsuarios){
            if(s.equals(usuario.getEmail())){
                flag = true;
                break;
            }
        }
        return !flag;
    }
}
