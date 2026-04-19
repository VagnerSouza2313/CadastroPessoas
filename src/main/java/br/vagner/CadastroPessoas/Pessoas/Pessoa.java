package br.vagner.CadastroPessoas.Pessoas;

import br.vagner.CadastroPessoas.Atividades.Atividade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = "atividades")
@Table(name = "tb_cadastro")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private int idade;

    private String statusSocial;

    @ManyToOne
    @JoinColumn(name = "atividades_id")
    private Atividade atividades;


}
