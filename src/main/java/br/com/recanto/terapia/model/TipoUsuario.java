package br.com.recanto.terapia.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_tipo_usuario")
//@Inheritance(strategy=InheritanceType.JOINED)
public class TipoUsuario extends SuperPojo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8916216048572752556L;
	
	@Column(name="str_nome")
	private String nome;

	@Column(name="str_descricao")
	private String descricao;

	@OneToMany(mappedBy="tipoUsuario")
	private List<Usuario> usuarios;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
