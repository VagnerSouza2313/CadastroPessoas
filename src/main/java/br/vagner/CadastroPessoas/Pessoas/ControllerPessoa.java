package br.vagner.CadastroPessoas.Pessoas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pessoas")
public class ControllerPessoa {

    private ServicePessoa servicePessoa;

    public ControllerPessoa(ServicePessoa servicePessoa) {
        this.servicePessoa = servicePessoa;
    }

    @GetMapping("/pessoa")
    public String teste(){
        return "Teste API";

    }

    //Adicionar pessoa (CREATE)
    @PostMapping("/adicionar")
    public Pessoa pessoa(@RequestBody Pessoa pessoa){
        return servicePessoa.SalvarPessoa(pessoa);
    }

    //Procurar pessoa por id (CREATE)
    @GetMapping("/buscaID/{id}")
    public Pessoa buscaID(@PathVariable Long id){
        return servicePessoa.BuscarPessoa(id);
    }

    //Mostrar todas as pessoas (READ)
    @GetMapping("/todos")
    public List<Pessoa> ListarPessoas(){
        return  servicePessoa.ListarPessoas();
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
    @DeleteMapping("/deletarID/{id}")
    public void deletarPessoaPorID(@PathVariable Long id ){
        servicePessoa.deletarPessoa(id);
    }


}
