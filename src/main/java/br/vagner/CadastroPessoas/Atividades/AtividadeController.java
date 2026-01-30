package br.vagner.CadastroPessoas.Atividades;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AtividadeController {

    @GetMapping("/atividade")
    public String teste(){
        return "Teste API";
    }

}
