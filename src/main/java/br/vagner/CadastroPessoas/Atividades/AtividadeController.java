package br.vagner.CadastroPessoas.Atividades;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("atividades")
public class AtividadeController {

    @PostMapping("atividades/criar")
    public String criarAtividade() {
        return "Criar Atividade";
    }

    @PutMapping("atividades/alterar")
    public String alterarAtividade() {
        return "Alterar Atividade";
    }

    @DeleteMapping("atividades/deletar")
    public String deletarAtividade() {
        return "Deletar Atividade";
    }

    @GetMapping("atividades/listar")
    public String listarAtividades() {
        return "Listar Atividades";
    }

}
