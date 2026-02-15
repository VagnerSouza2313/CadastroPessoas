package br.vagner.CadastroPessoas.Pessoas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pessoas")
public class ControllerPessoa {

    @GetMapping("/pessoa")
    public String teste(){
        return "Teste API";

    }

    //Adicionar pessoa (CREATE)
    @PostMapping("/adicionar")
    public String criarNinja(){
        return  "Criando novo pessoa";
    }

    //Procurar pessoa por id (CREATE)
    @GetMapping("/buscaID")
    public String buscaID(){
        return "Buscando Pessoa";
    }

    //Mostrar todas as pessoas (READ)
    @GetMapping("/todos")
    public String MostrarTodasPessoas(){
        return  "Mostrando Pessoas";
    }

    //Mostrar pessoas por ID (READ)
    @GetMapping("/todosID")
    public String MostrarPorID(){
        return  "Mostrando Pessoa por ID";
    }

    //Alterar dados da pessoa (UPDATE)
    @PutMapping("/alterarID")
    public String alterarPessoaPorID(){
        return "Alterando Pessoa por ID";
    }

    //Deletar pessoa (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarPessoaPorID(){
        return  "Deletando Pessoa por ID";
    }


}
