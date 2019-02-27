package br.com.recanto.terapia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.recanto.terapia.model.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer>{

}
