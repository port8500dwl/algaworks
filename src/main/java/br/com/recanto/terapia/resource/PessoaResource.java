package br.com.recanto.terapia.resource;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.recanto.terapia.evento.RecursoCriadoEvento;
import br.com.recanto.terapia.exceptionhandler.Erro;
import br.com.recanto.terapia.exceptionhandler.PessoaInexistenteOuInativa;
import br.com.recanto.terapia.filter.PessoaFilter;
import br.com.recanto.terapia.model.Pessoa;
import br.com.recanto.terapia.model.Usuario;
import br.com.recanto.terapia.repository.pessoa.PessoaRepository;
import br.com.recanto.terapia.service.UsuarioService;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource extends SuperResource<Pessoa>{

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private MessageSource mensagemSourcoes;

	@Autowired
	private UsuarioService<Usuario> usuarioService;
	
	@GetMapping
	public List<Pessoa> filtrar(PessoaFilter filter){
		return this.pessoaRepository.filtrar(filter);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Pessoa> criar(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response) {
		Pessoa novoRegistro = this.pessoaRepository.save(pessoa);
		this.publisher.publishEvent(new RecursoCriadoEvento(this, response, novoRegistro.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(novoRegistro);
	}
	
	@GetMapping("{codigo}")
	public ResponseEntity<?> recuperarPeloCodigo(@PathVariable Integer codigo) {
		Pessoa pessoa = this.pessoaRepository.getOne(codigo);
		return pessoa!= null ? ResponseEntity.ok(pessoa) : ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<?> atualizar(@PathVariable Integer codigo, @Valid @RequestBody Pessoa entidade) {
		this.getEntidadeService().setPersistentClass(Pessoa.class);
		return ResponseEntity.ok(this.getEntidadeService().atualizar(entidade, codigo));
	}

	@PutMapping("/{codigo}/usuario/{codigo}")
	public ResponseEntity<?> atualizar(@PathVariable Integer codigo, @Valid @RequestBody Usuario entidade) {
		this.usuarioService.setPersistentClass(Usuario.class);
		return ResponseEntity.ok(this.usuarioService.atualizar(entidade, codigo));
	}
	
	@ExceptionHandler({PessoaInexistenteOuInativa.class})
	public ResponseEntity<Object> handlePessoaInexistenteOuInativaException(PessoaInexistenteOuInativa ex) {
		String mensagem = this.mensagemSourcoes.getMessage("pessoa-inativa-inexistente", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.getCause() != null? String.valueOf(ex.getCause()) : String.valueOf(ex);
		List<Erro> erros = Arrays.asList(new Erro(mensagem, mensagemDesenvolvedor));
		return ResponseEntity.badRequest().body(erros);
	}
	
}
