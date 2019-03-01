package br.com.recanto.terapia.repository.usuario.permissao;

import java.util.List;

import br.com.recanto.terapia.filter.PermissaoFilter;
import br.com.recanto.terapia.model.PermissaoUsuario;
import br.com.recanto.terapia.repository.impl.DaoImpl;

@SuppressWarnings("serial")
public class PermissaoUsuarioRepositoryImpl extends DaoImpl<PermissaoUsuario> implements PermissaoUsuarioRepositoryQuery{

	@Override
	public List<PermissaoUsuario> filtrar(PermissaoFilter filter) {
		return super.getListaFiltrada(filter, super.getRoot(), null);
	}

	
}
