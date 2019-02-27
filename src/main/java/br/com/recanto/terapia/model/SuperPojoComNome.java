package br.com.recanto.terapia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class SuperPojoComNome extends SuperPojo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8916216048572752556L;
	
	@Column(name="str_nome")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
 
}
