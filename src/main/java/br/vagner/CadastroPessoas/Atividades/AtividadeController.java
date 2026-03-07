package br.vagner.CadastroPessoas.Atividades;

import br.vagner.CadastroPessoas.Pessoas.PessoaDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("atividades")
public class AtividadeController {

    private ServiceAtividade  serviceAtividade;
    private AtividadeMapper atividadeMapper = new AtividadeMapper();

    public AtividadeController(ServiceAtividade serviceAtividade, AtividadeMapper atividadeMapper) {
        this.serviceAtividade = serviceAtividade;
        this.atividadeMapper = atividadeMapper;
    }

    @PostMapping("/criar")
    public AtividadeDTO criarPessoa(@RequestBody AtividadeDTO atividadeDTO){
        return serviceAtividade.criarAtividade(atividadeDTO);
    }

    @GetMapping("/listar")
    public List<AtividadeDTO>  listarAtividades() {
        return serviceAtividade.ListarAtividades();
    }

    @GetMapping("/listarId/{id}")
    public AtividadeDTO atividadeId(@PathVariable Long id){
       return serviceAtividade.atividadeID(id);
    }

    @PutMapping("/alterar/{id}")
    public AtividadeDTO atualizarAtividade(@PathVariable Long id,@RequestBody AtividadeDTO atividadeDTO){
        return serviceAtividade.atividadeAtualizar(id,atividadeDTO);
    }

    @DeleteMapping("/deletarAtividade/{id}")
    public void deletarAtividade(@PathVariable Long id){
        serviceAtividade.deletarAtividade(id);
    }


}
