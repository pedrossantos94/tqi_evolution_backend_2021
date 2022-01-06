package com.TQI.tqi_evolution_backend_2021.controller;

import com.TQI.tqi_evolution_backend_2021.datatransferobjects.RequisicaoNovaSolicitacao;
import com.TQI.tqi_evolution_backend_2021.model.Solicitacao;
import com.TQI.tqi_evolution_backend_2021.repository.SolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.lang.model.element.ModuleElement;
import java.security.Principal;

@Controller
public class SolicitacoesController {

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    @GetMapping("/solicitacoes")
    public String Solicitacoes(Model model, Principal principal){
        var listaSolicitacoes = solicitacaoRepository.findAllByUsuario(principal.getName());
        model.addAttribute("listaSolicitacoes", listaSolicitacoes);
        return "solicitacoes";
    }

}
