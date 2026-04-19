package br.vagner.CadastroPessoas.Atividades;

import br.vagner.CadastroPessoas.Pessoas.Pessoa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Table(name = "tb_atividades")
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String atividade;
    private String grau;

    @OneToMany(mappedBy = "atividades")
    @JsonIgnore
    private List<Pessoa> pessoas;

}
