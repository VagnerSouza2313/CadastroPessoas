package br.vagner.CadastroPessoas.Pessoas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/pessoas/ui")
public class PessoaControllerUI {

    private final ServicePessoa servicePessoa;

    public PessoaControllerUI(ServicePessoa servicePessoa) {
        this.servicePessoa = servicePessoa;
    }


    @GetMapping("/todosID/{id}")
    public String buscaID(@PathVariable Long id, Model model) {
        PessoaDTO pessoaDTO = servicePessoa.BuscarPessoa(id);
        if (pessoaDTO != null) {
            model.addAttribute("pessoaID", pessoaDTO);
            return "detalhesPessoa";
        }
        else{
            model.addAttribute("mensagem", "Pessoa não foi encontrada");
            return "listarPessoas";
        }
    }


    @GetMapping("/todos")
    public String ListarPessoas(Model model){
        List<PessoaDTO> pessoaDTOList = servicePessoa.ListarPessoas();
        model.addAttribute("pessoas", pessoaDTOList);
        return "listarPessoas"; // retorna a pagina que renderiza
    }

    @GetMapping("/deletarID/{id}")
    public String deletarPessoaPorID(@PathVariable Long id ){
        servicePessoa.deletarPessoa(id);
        return "redirect:/pessoas/ui/todos";

    }

}
