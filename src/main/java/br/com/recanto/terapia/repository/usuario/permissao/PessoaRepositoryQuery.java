package br.com.recanto.terapia.repository.usuario.permissao;

import java.util.List;

import br.com.recanto.terapia.filter.PermissaoFilter;
import br.com.recanto.terapia.model.PermissaoUsuario;

public interface PessoaRepositoryQuery {
	public List<PermissaoUsuario> filtrar(PermissaoFilter fiter);
}
