package br.com.recanto.terapia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.recanto.terapia.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
