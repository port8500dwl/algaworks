package br.com.recanto.terapia.repository.usuario.permissao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.recanto.terapia.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>, PessoaRepositoryQuery{}
