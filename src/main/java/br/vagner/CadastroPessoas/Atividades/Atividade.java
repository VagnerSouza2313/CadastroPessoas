package br.vagner.CadastroPessoas.Atividades;

import br.vagner.CadastroPessoas.Pessoas.Pessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tb_atividades")
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String atividade;
    private String grau;

    @OneToMany(mappedBy = "atividades")
    private Pessoa pessoa;


}
