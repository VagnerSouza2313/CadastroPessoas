package br.vagner.CadastroPessoas.Pessoas;

import br.vagner.CadastroPessoas.Atividades.Atividade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_cadastro")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private int idade;

    @ManyToOne
    @JoinColumn(name = "atividades_id")
    private Atividade atividades;


}
