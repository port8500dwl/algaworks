package br.com.recanto.terapia.repository;

import java.io.Serializable;

import br.com.recanto.terapia.model.SuperPojo;

@SuppressWarnings("hiding")
public interface Dao<T, Integer> extends Serializable {

	public abstract void setPersistentClass(final Class<T> entidade);
	
	SuperPojo findOne(java.lang.Integer codigo);

	SuperPojo save(SuperPojo p);

	public abstract void delete(java.lang.Integer codigo);

}
