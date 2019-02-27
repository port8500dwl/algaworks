package br.com.recanto.terapia.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.recanto.terapia.evento.RecursoCriadoEvento;
import br.com.recanto.terapia.model.Usuario;
import br.com.recanto.terapia.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource extends SuperResource<Usuario>{

	@Autowired
	private UsuarioRepository repositorEntidade;

	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		List<Usuario> tipoUsuarios = this.repositorEntidade.findAll();
		return !tipoUsuarios.isEmpty() ? ResponseEntity.ok(tipoUsuarios) : ResponseEntity.noContent().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Usuario> criar(@Valid @RequestBody Usuario entidade, HttpServletResponse response) {
		Usuario novoRegistro = this.repositorEntidade.save(entidade);
		this.publisher.publishEvent(new RecursoCriadoEvento(this, response, novoRegistro.getPessoa().getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(novoRegistro);
	}
	
	@GetMapping("{codigo}")
	public ResponseEntity<?> recuperarPeloCodigo(@PathVariable Integer codigo) {
		Usuario entidade = this.repositorEntidade.findOne(codigo);
		return entidade != null ? ResponseEntity.ok(entidade) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Integer codigo) {
		this.repositorEntidade.delete(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<?> atualizar(@PathVariable Integer codigo, @Valid @RequestBody Usuario entidade) {
		super.getEntidadeService().setPersistentClass(Usuario.class);
		return ResponseEntity.ok(super.getEntidadeService().atualizar(entidade, codigo));
		
	}
	
	
}
