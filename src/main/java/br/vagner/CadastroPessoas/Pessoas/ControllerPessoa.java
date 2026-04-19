package br.vagner.CadastroPessoas.Pessoas;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("pessoas")
public class ControllerPessoa {

    private final ServicePessoa servicePessoa;

    public ControllerPessoa(ServicePessoa servicePessoa) {
        this.servicePessoa = servicePessoa;
    }

    //Adicionar pessoa (CREATE)
    @PostMapping("/adicionar")
    public ResponseEntity<String> pessoa(@RequestBody PessoaDTO pessoa){
        PessoaDTO pessoaDTO = servicePessoa.SalvarPessoa(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Pessoa criada com sucesso" + pessoaDTO.getNome());
    }

    //Mostrar todas as pessoas (READ)
    @GetMapping("/todos")
    public ResponseEntity<?> ListarPessoas(){
        List<PessoaDTO> pessoaDTOList = servicePessoa.ListarPessoas();
        return ResponseEntity.ok(pessoaDTOList);
    }

    //Mostrar pessoas por ID (READ)
    @GetMapping("/todosID/{id}")
    public ResponseEntity<?> buscaID(@PathVariable Long id) {
        PessoaDTO pessoaDTO = servicePessoa.BuscarPessoa(id);
        if (pessoaDTO != null) {
            return ResponseEntity.ok(pessoaDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Pessoa não encontrada em nossos registros! ID: " + id);

        }
    }

    //Alterar dados da pessoa (UPDATE)
    @PutMapping("/alterarID/{id}")
    public ResponseEntity<String> alterarPessoaPorID(@PathVariable Long id, @RequestBody PessoaDTO pessoa){
        if (servicePessoa.BuscarPessoa(id) != null){
            servicePessoa.atualizarPessoa(id, pessoa);
            return ResponseEntity.ok("Pessoa atualizada com sucesso. ID: " + id);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Digite um ID válido.");
        }
    }

    //Deletar pessoa (DELETE)
    @DeleteMapping("/deletarID/{id}")
    public ResponseEntity<String> deletarPessoaPorID(@PathVariable Long id ){
        if (servicePessoa.BuscarPessoa(id) != null){
            servicePessoa.deletarPessoa(id);
            return ResponseEntity.ok("Pessoa deletada com sucesso. ID: " + id);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Pessoa com ID: " + id + " não encontrado.");
        }

    }


}
