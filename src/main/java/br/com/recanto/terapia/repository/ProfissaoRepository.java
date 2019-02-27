package br.com.recanto.terapia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.recanto.terapia.model.Profissao;

public interface ProfissaoRepository  extends JpaRepository<Profissao, Integer>{

	
}
