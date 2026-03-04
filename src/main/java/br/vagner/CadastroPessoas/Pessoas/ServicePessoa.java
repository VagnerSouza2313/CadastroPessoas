package br.vagner.CadastroPessoas.Pessoas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicePessoa {

    private RepositoryPessoa repositoryPessoa;
    private PessoaMapper pessoaMapper;

    public ServicePessoa(RepositoryPessoa repositoryPessoa, PessoaMapper pessoaMapper) {
        this.repositoryPessoa = repositoryPessoa;
        this.pessoaMapper = pessoaMapper;
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
    public PessoaDTO SalvarPessoa(PessoaDTO pessoaDTO){
        Pessoa pessoa1 = pessoaMapper.map(pessoaDTO);
        pessoa1 = repositoryPessoa.save(pessoa1);
        return pessoaMapper.map(pessoa1);
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
