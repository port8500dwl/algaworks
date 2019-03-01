package br.com.recanto.terapia.repository.uf;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.util.StringUtils;

import br.com.recanto.terapia.filter.UfFilter;
import br.com.recanto.terapia.model.UF;
import br.com.recanto.terapia.repository.impl.DaoImpl;

@SuppressWarnings("serial")
public class UFRepositoryQueryImpl extends DaoImpl<UF> implements UFRepositoryQuery {

	@Override
	public List<UF> filtrar(UfFilter filter) {
		Root<UF> root = super.getRoot();
		Predicate[] preticates = this.criarRestricoesUf(filter, this.getBuilder(), root);
		return getListaFiltrada(filter, root, preticates);
	}

	private Predicate[] criarRestricoesUf(UfFilter filter, CriteriaBuilder builder, Root<UF> root) {
		List<Predicate> predicates = new ArrayList<Predicate>();

		if (!StringUtils.isEmpty(filter.getSigla())) {
			predicates.add(builder.like(builder.lower(root.get("sigla")), "%" + filter.getSigla().toLowerCase() + "%"));
		}
		return super.retornoPredicate(predicates);
	}
	
	
}
