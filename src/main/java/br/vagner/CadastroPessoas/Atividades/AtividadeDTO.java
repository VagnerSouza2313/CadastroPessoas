package br.vagner.CadastroPessoas.Atividades;

import br.vagner.CadastroPessoas.Pessoas.Pessoa;
import br.vagner.CadastroPessoas.Pessoas.PessoaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//Classe para tirar a responsabilidade da
//entidade Pessoa, não acessando diretamente minha entidade
public class AtividadeDTO {

    private Long id;
    private String atividade;
    private String grau;
    private List<PessoaDTO> pessoas;

}
