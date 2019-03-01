package br.com.recanto.terapia.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.recanto.terapia.model.SuperPojo;
import br.com.recanto.terapia.repository.Dao;

@Service("genericService")
@Qualifier("genericService")
public class GenericService<T> {

	
	@Autowired
	protected Dao<T, Integer> dao;
	
	protected Class<T> persistentClass;

	public SuperPojo atualizar(SuperPojo entidade, Integer codigo) {
		this.dao.setPersistentClass(this.persistentClass);
		SuperPojo p  =  this.dao.findOne(codigo);
		if (p == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(entidade, p, "id");
		return this.dao.save(p);
	}

	public void delete(Integer codigo) {
		this.dao.delete(codigo);
	}
	
	
	public void setDao(Dao<T, Integer> dao) {
		this.dao = dao;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	public Dao<T, Integer> getDao() {
		return dao;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

}
