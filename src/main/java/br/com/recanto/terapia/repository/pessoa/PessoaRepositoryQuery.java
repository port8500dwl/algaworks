package br.com.recanto.terapia.repository.pessoa;

import java.util.List;

import br.com.recanto.terapia.filter.PessoaFilter;
import br.com.recanto.terapia.model.Pessoa;

public interface PessoaRepositoryQuery {
	
	public List<Pessoa> filtrar(PessoaFilter fiter);
}
