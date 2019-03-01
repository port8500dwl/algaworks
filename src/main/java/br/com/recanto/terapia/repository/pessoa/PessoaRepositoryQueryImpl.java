package br.com.recanto.terapia.repository.pessoa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.util.StringUtils;

import br.com.recanto.terapia.filter.PessoaFilter;
import br.com.recanto.terapia.model.Pessoa;
import br.com.recanto.terapia.repository.impl.DaoImpl;

@SuppressWarnings("serial")
public class PessoaRepositoryQueryImpl extends DaoImpl<Pessoa> implements PessoaRepositoryQuery {

	@Override
	public List<Pessoa> filtrar(PessoaFilter filter) {
		Root<Pessoa> root = super.getRoot();
		Predicate[] preticates = this.criarRestricoesPessoa(filter, this.getBuilder(), root);
		return getListaFiltrada(filter, root, preticates);
	}
	
	private Predicate[] criarRestricoesPessoa(PessoaFilter filter, CriteriaBuilder builder, Root<Pessoa> root) {
		List<Predicate> predicates = new ArrayList<Predicate>();

		if (!StringUtils.isEmpty(filter.getEmail())) {
			predicates.add(builder.equal(builder.lower(root.get("email")), filter.getEmail().toLowerCase()));
		}
		return super.retornoPredicate(predicates);
	}
	

}
