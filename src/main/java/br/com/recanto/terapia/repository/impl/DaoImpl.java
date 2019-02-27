package br.com.recanto.terapia.repository.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

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
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public DaoImpl() {
		if (getClass().getGenericSuperclass() instanceof ParameterizedType) {
			this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		}
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

	@Override
	public void setPersistentClass(Class<T> entidade) {
		this.persistentClass = entidade;
	}


}
