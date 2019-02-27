package br.com.recanto.terapia.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class Endereco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7457036097669070237L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="str_nome")
	private String nome;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="dt_nascimento")
	private LocalDate dataNascimento;
	
	@Column(name="bol_ativo")
	private String ativo;

	
}
