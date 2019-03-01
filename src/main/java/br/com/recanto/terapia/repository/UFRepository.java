package br.com.recanto.terapia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.recanto.terapia.model.UF;
import br.com.recanto.terapia.repository.uf.UFRepositoryQuery;

public interface UFRepository extends JpaRepository<UF, Integer>, UFRepositoryQuery {}
