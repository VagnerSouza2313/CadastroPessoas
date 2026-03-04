package br.vagner.CadastroPessoas.Pessoas;

import br.vagner.CadastroPessoas.Atividades.Atividade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//Classe para tirar a responsabilidade da entidade Pessoa, não acessando diretamente minha entidade
public class PessoaDTO {

    private Long id;
    private String nome;
    private String email;
    private int idade;
    private String statusSocial;
    private Atividade atividades;

}
