package br.com.recanto.terapia.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="tb_pessoa")
@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
public class Pessoa extends SuperPojoComNome implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8916216048572752556L;
	
	@Column(name="str_email")
	private String email;

	@Column(name="str_sobrenome")
	private String sobreNome;
	
	@Column(name="str_sexo")
	private String sexo;
	
	@Column(name="str_estado_civil")
	private String estadoCivil;
	
	@Column(name="str_altura")
	@Size(min=2, max=4)
	private String altura;
	
	@Column(name="str_peso")
	private String peso;
	
	@Column(name="str_filhos")
	private String filhos;
	
	@Column(name="str_indicacao")
	private String indicacao;
	
	@Column(name="str_nome_indicacao")
	private String nomeIndicacao;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="dat_nascimento")
	private LocalDate dataAniversario;
	
	@OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private Usuario usuario;

	@OneToOne
	@JoinColumn(name = "profissao_id", unique=true)
	private Profissao profissao;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getAltura() {
		return altura;
	}
	public void setAltura(String altura) {
		this.altura = altura;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public String getFilhos() {
		return filhos;
	}
	public void setFilhos(String filhos) {
		this.filhos = filhos;
	}
	public String getIndicacao() {
		return indicacao;
	}
	public void setIndicacao(String indicacao) {
		this.indicacao = indicacao;
	}
	public String getNomeIndicacao() {
		return nomeIndicacao;
	}
	public void setNomeIndicacao(String nomeIndicacao) {
		this.nomeIndicacao = nomeIndicacao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Profissao getProfissao() {
		return profissao;
	}
	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	public LocalDate getDataAniversario() {
		return dataAniversario;
	}
	public void setDataAniversario(LocalDate dataAniversario) {
		this.dataAniversario = dataAniversario;
	}
	

}
