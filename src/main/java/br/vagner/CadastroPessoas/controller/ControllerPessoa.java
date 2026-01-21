package br.vagner.CadastroPessoas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ControllerPessoa {

    @GetMapping("/teste")
    public String teste(){
        return "Teste API";
    }

}
