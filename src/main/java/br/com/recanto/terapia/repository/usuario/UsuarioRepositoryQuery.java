package br.com.recanto.terapia.repository.usuario;

import java.util.List;

import br.com.recanto.terapia.filter.UsuarioFilter;
import br.com.recanto.terapia.model.Usuario;

public interface UsuarioRepositoryQuery {
	
	public List<Usuario> filtrar(UsuarioFilter filter);

}
