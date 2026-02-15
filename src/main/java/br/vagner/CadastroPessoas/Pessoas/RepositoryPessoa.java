package br.vagner.CadastroPessoas.Pessoas;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryPessoa extends JpaRepository<Pessoa, Long> {
}
