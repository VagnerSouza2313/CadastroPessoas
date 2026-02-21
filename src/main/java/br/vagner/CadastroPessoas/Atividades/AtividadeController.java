package br.vagner.CadastroPessoas.Atividades;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("atividades")
public class AtividadeController {

    private ServiceAtividade  serviceAtividade;

    public AtividadeController(ServiceAtividade serviceAtividade){
        this.serviceAtividade = serviceAtividade;
    }

    @PostMapping("/criar")
    public String criarAtividade() {
        return "Criar Atividade";
    }

    @PutMapping("/alterar")
    public String alterarAtividade() {
        return "Alterar Atividade";
    }

    @DeleteMapping("/deletar")
    public String deletarAtividade() {
        return "Deletar Atividade";
    }

    @GetMapping("/listar")
    public List<Atividade>  listarAtividades() {
        return serviceAtividade.ListarAtividades();
    }

}
