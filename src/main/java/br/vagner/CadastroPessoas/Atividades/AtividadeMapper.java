package br.vagner.CadastroPessoas.Atividades;

import br.vagner.CadastroPessoas.Pessoas.Pessoa;
import br.vagner.CadastroPessoas.Pessoas.PessoaDTO;
import br.vagner.CadastroPessoas.Pessoas.PessoaMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AtividadeMapper {

    PessoaMapper pessoaMapper = new PessoaMapper();

    public Atividade map(AtividadeDTO atividadeDTO){
        Atividade atividade = new Atividade();

        atividade.setAtividade(atividadeDTO.getAtividade());
        atividade.setId(atividadeDTO.getId());
        atividade.setGrau(atividadeDTO.getGrau());

        if (atividadeDTO.getPessoas() != null){
            List<Pessoa> pessoas = atividadeDTO.getPessoas()
                    .stream().map(pessoaMapper::map).collect(Collectors.toList());
            atividade.setPessoas(pessoas);
        }

        return atividade;
    }

    public AtividadeDTO map(Atividade atividade){
        AtividadeDTO atividadeDTO = new AtividadeDTO();

        atividadeDTO.setId(atividade.getId());
        atividadeDTO.setAtividade(atividade.getAtividade());
        atividadeDTO.setGrau(atividade.getGrau());
        List<PessoaDTO> pessoas = atividade.getPessoas()
                .stream()
                .map(pessoaMapper::map)
                .collect(Collectors.toList());
        atividadeDTO.setPessoas(pessoas);

        return atividadeDTO;
    }

}
