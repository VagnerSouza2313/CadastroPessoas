package br.vagner.CadastroPessoas.Pessoas;

import org.springframework.stereotype.Component;

@Component
public class PessoaMapper {

    public Pessoa map(PessoaDTO pessoaDTO){
        Pessoa pessoa = new Pessoa();
        pessoa.setId(pessoaDTO.getId());
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setEmail(pessoaDTO.getEmail());
        pessoa.setAtividades(pessoaDTO.getAtividades());
        pessoa.setStatusSocial(pessoaDTO.getStatusSocial());
        pessoa.setAtividades(pessoaDTO.getAtividades());

        return pessoa;
    }

    public PessoaDTO map(Pessoa pessoa){
            PessoaDTO pessoaDTO = new PessoaDTO();
            pessoaDTO.setId(pessoa.getId());
            pessoaDTO.setNome(pessoa.getNome());
            pessoaDTO.setEmail(pessoa.getEmail());
            pessoaDTO.setIdade(pessoa.getIdade());
            pessoaDTO.setEmail(pessoa.getEmail());
            pessoaDTO.setStatusSocial(pessoa.getStatusSocial());
            pessoaDTO.setAtividades(pessoa.getAtividades());

            return pessoaDTO;
    }

}
