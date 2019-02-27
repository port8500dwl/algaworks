package br.com.recanto.terapia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="tb_profissao")
public class Profissao extends SuperPojoComNome implements Serializable{


	@Column(name="str_observacao")
	private String observacao;


	public String getObservacao() {
		return observacao;
	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	
}
