package br.com.recanto.terapia.repository.usuario.permissao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.recanto.terapia.model.PermissaoUsuario;

public interface PermissaoUsuarioRepository extends JpaRepository<PermissaoUsuario, Integer>, PermissaoUsuarioRepositoryQuery {
	
}
