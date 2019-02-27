package br.com.recanto.terapia.exceptionhandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

@ControllerAdvice
public class TerapiaExceptionHandler extends ResponseEntityExceptionHandler{

	@Autowired
	private MessageSource mensagemSourcoes;
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		String mensagem = this.mensagemSourcoes.getMessage("mensagem-invalida", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.getCause().toString();
		List<Erro> erros = Arrays.asList(new Erro(mensagem, mensagemDesenvolvedor));
		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<Erro> erros = criarLIstaErro(ex.getBindingResult());
		return handleExceptionInternal(ex, erros , headers, HttpStatus.BAD_REQUEST, request);
	}

	private List<Erro> criarLIstaErro(BindingResult bindingResult) {
		List<Erro> retorno = new ArrayList<Erro>();
		for (FieldError erro : bindingResult.getFieldErrors()) {
			String mensagem = this.mensagemSourcoes.getMessage(erro, LocaleContextHolder.getLocale());
			String mensagemDesenvolvedor = erro.toString();
			retorno.add(new Erro(mensagem, mensagemDesenvolvedor));
		}
		return retorno;
	}
	
	@ExceptionHandler({EmptyResultDataAccessException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex, WebRequest request) {
		String mensagem = this.mensagemSourcoes.getMessage("registro-nao-encontrado", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.getMessage();
		List<Erro> erros = Arrays.asList(new Erro(mensagem, mensagemDesenvolvedor));
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
		
	}

	@ExceptionHandler({JpaSystemException.class})
	@ResponseStatus(HttpStatus.NOT_MODIFIED)
	public ResponseEntity<Object> handleJpaSystemException(JpaSystemException ex, WebRequest request) {
		String mensagem = this.mensagemSourcoes.getMessage("erro-jpa-generico", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.getMessage();
		List<Erro> erros = Arrays.asList(new Erro(mensagem, mensagemDesenvolvedor));
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	@ExceptionHandler({UnrecognizedPropertyException.class})
	@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
	public ResponseEntity<Object> handleUnrecognizedPropertyException(UnrecognizedPropertyException ex, WebRequest request) {
		String mensagem = this.mensagemSourcoes.getMessage("preenchimento-invalido", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.getMessage();
		List<Erro> erros = Arrays.asList(new Erro(mensagem, mensagemDesenvolvedor));
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
		
	}

	@ExceptionHandler({DataIntegrityViolationException.class})
	@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
	public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) {
		String mensagem = this.mensagemSourcoes.getMessage("preenchimento-invalido", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.getMessage();
		List<Erro> erros = Arrays.asList(new Erro(mensagem, mensagemDesenvolvedor));
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
		
	}

	@ExceptionHandler({ConstraintViolationException.class})
	@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
	public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request) {
		String mensagem = this.mensagemSourcoes.getMessage("preenchimento-invalido", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.getMessage();
		List<Erro> erros = Arrays.asList(new Erro(mensagem, mensagemDesenvolvedor));
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
		
	}
	
}
