package com.TQI.tqi_evolution_backend_2021.controller;

import com.TQI.tqi_evolution_backend_2021.model.Cliente;
import com.TQI.tqi_evolution_backend_2021.model.Solicitacao;
import com.TQI.tqi_evolution_backend_2021.repository.CadastroUsuarioRepository;
import com.TQI.tqi_evolution_backend_2021.repository.SolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Optional;

@Controller
public class DetalheSolicitacaoController {

    @Autowired
    SolicitacaoRepository solicitacaoRepository;

    @Autowired
    CadastroUsuarioRepository cadastroUsuarioRepository;

    @GetMapping("/detalheSolicitacao")
    public String detalheSolicitacao(@RequestParam(value="id", required = true) Long id, Model model, Principal principal){

        Cliente cliente = cadastroUsuarioRepository.findByEmail(principal.getName());
        Optional<Solicitacao> solicitacaoTemp = solicitacaoRepository.findById(id);
        var solicitacao = new Solicitacao();
        solicitacao.setCodigo(solicitacaoTemp.get().getCodigo());
        solicitacao.setPrimeiraParcela(solicitacaoTemp.get().getPrimeiraParcela());
        solicitacao.setValor(solicitacaoTemp.get().getValor());
        solicitacao.setQuantidadeParcelas(solicitacaoTemp.get().getQuantidadeParcelas());
        model.addAttribute("solicitacao", solicitacao);
        model.addAttribute("cliente",cliente);
        return "detalheSolicitacao";
    }
}
