package br.vagner.CadastroPessoas.Atividades;

import br.vagner.CadastroPessoas.Pessoas.Pessoa;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_atividades")
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String atividade;
    private String grau;

    @OneToMany
    private Pessoa pessoa;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}
