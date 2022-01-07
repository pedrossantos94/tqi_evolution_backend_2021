package com.TQI.tqi_evolution_backend_2021.controller;

import com.TQI.tqi_evolution_backend_2021.datatransferobjects.RequisicaoNovoUsuario;
import com.TQI.tqi_evolution_backend_2021.model.Authority;
import com.TQI.tqi_evolution_backend_2021.model.Cliente;
import com.TQI.tqi_evolution_backend_2021.model.User;
import com.TQI.tqi_evolution_backend_2021.repository.AuthorityRepository;
import com.TQI.tqi_evolution_backend_2021.repository.CadastroUsuarioRepository;
import com.TQI.tqi_evolution_backend_2021.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import java.security.Principal;

@Controller
public class CadastroUsuarioController {

    @Autowired
    private CadastroUsuarioRepository cadastroUsuarioRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @GetMapping("/cadastroUsuario")
    public String CadastroUsuario(RequisicaoNovoUsuario requisicao){
        return "cadastroUsuario";
    }

    @PostMapping("/cadastroUsuario")
    public String salvaUsuario(@Valid RequisicaoNovoUsuario requisicao, BindingResult result, Principal principal){

        if(result.hasErrors()){
            return "cadastroUsuario";
        }

        Cliente temp = requisicao.toUsuario();
        cadastroUsuarioRepository.save(temp);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User novoUser = new User();
        novoUser.setUsername(temp.getEmail());
        novoUser.setPassword(encoder.encode(temp.getSenha()));
        novoUser.setEnabled(true);

        Authority authority = new Authority();
        authority.setUsername(novoUser.getUsername());
        authority.setAuthority("ROLE_USER");

        userRepository.save(novoUser);
        authorityRepository.save(authority);

        return "home";
    }
}

