package br.com.recanto.terapia.filter;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class SuperFilter implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4369246913379213020L;

	private String nome;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataCadastroDe;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataCadastroA;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataCadastroDe() {
		return dataCadastroDe;
	}
	public void setDataCadastroDe(LocalDate dataCadastroDe) {
		this.dataCadastroDe = dataCadastroDe;
	}
	public LocalDate getDataCadastroA() {
		return dataCadastroA;
	}
	public void setDataCadastroA(LocalDate dataCadastroA) {
		this.dataCadastroA = dataCadastroA;
	}
	
}
