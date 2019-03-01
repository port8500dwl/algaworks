package br.com.recanto.terapia.repository.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.recanto.terapia.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>, PessoaRepositoryQuery{}
