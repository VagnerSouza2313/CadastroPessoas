package br.vagner.CadastroPessoas.Pessoas;

import org.springframework.stereotype.Service;

import java.util.List;

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

}
