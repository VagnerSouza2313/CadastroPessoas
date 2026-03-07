package br.vagner.CadastroPessoas.Atividades;
import br.vagner.CadastroPessoas.Pessoas.PessoaMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceAtividade {

    RepositoryAtividade repositoryAtividades;
    AtividadeMapper atividadeMapper = new AtividadeMapper();

    public ServiceAtividade(RepositoryAtividade repositoryAtividades) {
        this.repositoryAtividades = repositoryAtividades;
    }

    //Criar Atividade
    public AtividadeDTO criarAtividade(AtividadeDTO atividadeDTO){
        Atividade atividade = atividadeMapper.map(atividadeDTO);
        repositoryAtividades.save(atividade);
        return atividadeMapper.map(atividade);

    }

    //Listar Atividades
    public List<AtividadeDTO> ListarAtividades(){
        List<Atividade> atividadeList = repositoryAtividades.findAll();
        return atividadeList.stream().map(atividadeMapper::map).collect(Collectors.toList());
    }

    //Listar por id
    public AtividadeDTO atividadeID(Long id){
        Optional<Atividade> atividade = repositoryAtividades.findById(id);
        return atividade.map(atividadeMapper::map).orElse(null);
    }

    //Atualizar atividade
    public AtividadeDTO atividadeAtualizar(Long id, AtividadeDTO atividadeDTO){
        Optional<Atividade> atividadeExistente = repositoryAtividades.findById(id);
        if (atividadeExistente.isPresent()){
            Atividade atividadeAtualizada = atividadeMapper.map(atividadeDTO);
            atividadeAtualizada.setId(id);
            Atividade atividadeSalvo = repositoryAtividades.save(atividadeAtualizada);
            return atividadeMapper.map(atividadeSalvo);
        }
        return null;
    }

    //Deletar atividade
    public void deletarAtividade(Long id){
        repositoryAtividades.deleteById(id);
    }


}
