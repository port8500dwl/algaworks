package br.com.recanto.terapia.repository.usuario;

import java.util.List;

import br.com.recanto.terapia.filter.UsuarioFilter;
import br.com.recanto.terapia.model.Usuario;
import br.com.recanto.terapia.repository.impl.DaoImpl;

@SuppressWarnings("serial")
public class UsuarioRepositoryQueryImpl extends DaoImpl<Usuario> implements UsuarioRepositoryQuery {

	@Override
	public List<Usuario> filtrar(UsuarioFilter filter) {
		//Predicate[] preticates = super.criarRestricoes(filter, this.getBuilder(), this.getRoot());
		return super.getListaFiltrada(filter, super.getRoot(), null);
	}

}
