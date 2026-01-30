package br.vagner.CadastroPessoas.Pessoas;

import br.vagner.CadastroPessoas.Atividades.Atividade;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_cadastro")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private int idade;
    private String email;

    @ManyToOne
    @JoinColumn(name = "atividades_id")
    private Atividade atividades;

    public Pessoa() {
    }

    public Pessoa(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
