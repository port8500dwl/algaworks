package br.com.recanto.terapia.evento;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

public class RecursoCriadoEvento extends ApplicationEvent{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1479714072271520291L;
	private HttpServletResponse response; 
	private Integer codigo;

	public RecursoCriadoEvento(Object source, HttpServletResponse response, Integer codigo) {
		super(source);
		this.response = response;
		this.codigo = codigo;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public Integer getCodigo() {
		return codigo;
	}

}
