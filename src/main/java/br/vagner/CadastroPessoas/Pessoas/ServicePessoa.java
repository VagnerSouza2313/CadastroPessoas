package br.vagner.CadastroPessoas.Pessoas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicePessoa {

    private RepositoryPessoa repositoryPessoa;
    private PessoaMapper pessoaMapper;

    public ServicePessoa(RepositoryPessoa repositoryPessoa, PessoaMapper pessoaMapper) {
        this.repositoryPessoa = repositoryPessoa;
        this.pessoaMapper = pessoaMapper;
    }

    //Listar pessoas
    public List<PessoaDTO> ListarPessoas(){
        List<Pessoa> pessoas = repositoryPessoa.findAll();
      return  pessoas.stream()
                .map(pessoaMapper::map)
                .collect(Collectors.toList());
    }
    
    //Listar por id
    public PessoaDTO BuscarPessoa(Long id){
        Optional<Pessoa> pessoaID = repositoryPessoa.findById(id);
        return pessoaID.map(pessoaMapper::map).orElse(null);
    }

    //Criar pessoa
    public PessoaDTO SalvarPessoa(PessoaDTO pessoaDTO){
        Pessoa pessoa1 = pessoaMapper.map(pessoaDTO);
        pessoa1 = repositoryPessoa.save(pessoa1);
        return pessoaMapper.map(pessoa1);
    }

    //Atualizar pessoa
    public PessoaDTO atualizarPessoa(Long id, PessoaDTO pessoaDTO){
        Optional<Pessoa> pessoaExistenteID = repositoryPessoa.findById(id);
        if (pessoaExistenteID.isPresent()){
            Pessoa pessoaAtualizado = pessoaExistenteID.get();
            pessoaAtualizado.setNome(pessoaDTO.getNome());
            pessoaAtualizado.setEmail(pessoaDTO.getEmail());
            pessoaAtualizado.setIdade(pessoaDTO.getIdade());
            pessoaAtualizado.setStatusSocial(pessoaDTO.getStatusSocial());
            pessoaAtualizado.setAtividades(pessoaDTO.getAtividades());
            Pessoa pessoaSalvo = repositoryPessoa.save(pessoaAtualizado);
            return pessoaMapper.map(pessoaSalvo);
        }
        return null;
    }

    //Deletar pessoa - Metodo void
    public void deletarPessoa(Long id){
        repositoryPessoa.deleteById(id);
    }


}
