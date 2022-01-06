package com.TQI.tqi_evolution_backend_2021.controller;

import com.TQI.tqi_evolution_backend_2021.datatransferobjects.RequisicaoNovaSolicitacao;
import com.TQI.tqi_evolution_backend_2021.model.Solicitacao;
import com.TQI.tqi_evolution_backend_2021.model.User;
import com.TQI.tqi_evolution_backend_2021.repository.SolicitacaoRepository;
import com.TQI.tqi_evolution_backend_2021.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class NovaSolicitacaoController {

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/novaSolicitacao")
    public String NovaSolicitacao(RequisicaoNovaSolicitacao requisicao){
        return "novaSolicitacao";
    }

    @PostMapping("/novaSolicitacao")
    public String salvaSolicitacao(@Valid RequisicaoNovaSolicitacao requisicao, BindingResult result){
        if(result.hasErrors()){
            return "/novaSolicitacao";
        }

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);
        Solicitacao temp = requisicao.toSolicitacao();
        temp.setUser(user);
        solicitacaoRepository.save(temp);
        return "home";
    }
}
