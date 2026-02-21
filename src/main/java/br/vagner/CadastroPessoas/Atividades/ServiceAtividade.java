package br.vagner.CadastroPessoas.Atividades;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceAtividade {

    RepositoryAtividade repositoryAtividades;

    public ServiceAtividade(RepositoryAtividade repositoryAtividades) {
        this.repositoryAtividades = repositoryAtividades;
    }

    public List<Atividade> ListarAtividades(){
        return repositoryAtividades.findAll();
    }

}
