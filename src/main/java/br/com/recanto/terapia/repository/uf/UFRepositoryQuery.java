package br.com.recanto.terapia.repository.uf;

import java.util.List;

import br.com.recanto.terapia.filter.UfFilter;
import br.com.recanto.terapia.model.UF;

public interface UFRepositoryQuery {

	public List<UF> filtrar(UfFilter filter);

}
