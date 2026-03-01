package br.vagner.CadastroPessoas.Pessoas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicePessoa {

    private RepositoryPessoa repositoryPessoa;

    public  ServicePessoa(RepositoryPessoa repositoryPessoa1){
        this.repositoryPessoa = repositoryPessoa1;
    }

    //Listar pessoas
    public List<Pessoa> ListarPessoas(){
        return repositoryPessoa.findAll();
    }
    
    //Listar por id
    public Pessoa BuscarPessoa(Long id){
        Optional<Pessoa> pessoaID = repositoryPessoa.findById(id);
        return pessoaID.orElse(null);
    }

    //Criar pessoa
    public Pessoa SalvarPessoa(Pessoa pessoa){
        return repositoryPessoa.save(pessoa);
    }

    //Deletar pessoa - Metodo void
    public void deletarPessoa(Long id){
        repositoryPessoa.deleteById(id);
    }

    //Atualizar pessoa
    public Pessoa atualizarPessoa(Long id, Pessoa pessoa){
        if (repositoryPessoa.existsById(id)){
            pessoa.setId(id);
            return repositoryPessoa.save(pessoa);
        }
        return null;
    }

}
