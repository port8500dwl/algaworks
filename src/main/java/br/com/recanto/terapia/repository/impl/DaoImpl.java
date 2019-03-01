package br.com.recanto.terapia.repository.impl;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import br.com.recanto.terapia.filter.SuperFilter;
import br.com.recanto.terapia.model.SuperPojo;
import br.com.recanto.terapia.repository.Dao;

@Repository("dao")
@Qualifier("dao")
@Scope(proxyMode = ScopedProxyMode.NO, value = "prototype")
public class DaoImpl<T> implements Dao<T, Integer>{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5224843237803847039L;

	private Class<T> persistentClass;
	private Root<T> root;
	private CriteriaBuilder builder;
	
	@PersistenceContext
	private EntityManager entityManager;

	private CriteriaQuery<T> createQuery;
	
	@SuppressWarnings("unchecked")
	public DaoImpl() {
		if (getClass().getGenericSuperclass() instanceof ParameterizedType) {
			this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		}
	}
	
	@PostConstruct
	public void init01() {
		if (this.persistentClass != null) {
			this.builder = this.entityManager.getCriteriaBuilder();
			this.createQuery = builder.createQuery(this.persistentClass);
			this.root = this.createQuery.from(this.persistentClass);		
		}
	}
	

	public List<T> getListaFiltrada(SuperFilter filter, Root<T> root, Predicate[] preticates) {
		Predicate[] restricoes = criarRestricoes(filter, this.builder, this.root);
		if (preticates != null && preticates.length > 0) {
			restricoes = incrementarRestricoes(restricoes, preticates);
		}
		
		//adicionar as clausulas where
		this.createQuery.where(restricoes);
		return this.entityManager.createQuery(this.createQuery).getResultList();
	}


	public Predicate[] criarRestricoes(SuperFilter filter, CriteriaBuilder builder, Root<T> root) {

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (!StringUtils.isEmpty(filter.getNome())) {
			predicates.add(builder.like(builder.lower(root.get("nome")), "%" + filter.getNome().toLowerCase() + "%"));
		}

		if (filter.getDataCadastroDe() != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get("dataCadastro"), filter.getDataCadastroDe()));
		}
		if (filter.getDataCadastroA() != null) {
			predicates.add(builder.lessThan(root.get("dataCadastro"), filter.getDataCadastroA()));
		}
		return retornoPredicate(predicates);
	}


	protected Predicate[] retornoPredicate(List<Predicate> predicates) {
		return predicates.toArray(new Predicate[predicates.size()]);
	}		
	
	private Predicate[] incrementarRestricoes(Predicate[] preticatesPadraoFinal, Predicate[] preticates) {
		List<Predicate> preticatesFinal = new ArrayList<Predicate>();
		for (Predicate predicatePadrao : preticatesPadraoFinal) {
			preticatesFinal.add(predicatePadrao);
		}
		for (Predicate predicateComplemento : preticates) {
			preticatesFinal.add(predicateComplemento);
		}
		
		
		return retornoPredicate(preticatesFinal);
	}

	@Override
	public SuperPojo findOne(Integer codigo) {
		return (SuperPojo) this.entityManager.find(this.persistentClass, codigo);
	}

	@Override
	@Transactional 
	public SuperPojo save(SuperPojo p) {
		if (((SuperPojo) p).getId() == null) {
			this.entityManager.persist(p);
		} else {
			this.entityManager.merge(p);
		}
		return p;
	}

	public void delete(Integer codigo) {
		this.entityManager.remove(this.findOne(codigo));
	}

	
	protected CriteriaBuilder getBuilder() {
		return builder;
	}

	protected CriteriaQuery<T> getCriteria(CriteriaBuilder builder) {
		return createQuery;
	}

	protected Root<T> getRoot() {
		return root;
	}
	
	
	@Override
	public void setPersistentClass(Class<T> entidade) {
		this.persistentClass = entidade;
	}


	public EntityManager getEntityManager() {
		return entityManager;
	}

}
