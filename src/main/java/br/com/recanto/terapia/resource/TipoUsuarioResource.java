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
import br.com.recanto.terapia.model.TipoUsuario;
import br.com.recanto.terapia.repository.TipoUsuarioRepository;

@RestController
@RequestMapping("/tipoUsuario")
public class TipoUsuarioResource extends SuperResource<TipoUsuario>{

	@Autowired
	private TipoUsuarioRepository repositorEntidade;

	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		List<TipoUsuario> tipoUsuarios = this.repositorEntidade.findAll();
		return !tipoUsuarios.isEmpty() ? ResponseEntity.ok(tipoUsuarios) : ResponseEntity.noContent().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<TipoUsuario> criar(@Valid @RequestBody TipoUsuario entidade, HttpServletResponse response) {
		TipoUsuario novoRegistro = this.repositorEntidade.save(entidade);
		this.publisher.publishEvent(new RecursoCriadoEvento(this, response, novoRegistro.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(novoRegistro);
	}
	
	@GetMapping("{codigo}")
	public ResponseEntity<?> recuperarPeloCodigo(@PathVariable Integer codigo) {
		TipoUsuario entidade = this.repositorEntidade.findOne(codigo);
		return entidade != null ? ResponseEntity.ok(entidade) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Integer codigo) {
		this.repositorEntidade.delete(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<?> atualizar(@PathVariable Integer codigo, @Valid @RequestBody TipoUsuario entidade) {
		super.getEntidadeService().setPersistentClass(TipoUsuario.class);
		return ResponseEntity.ok(this.getEntidadeService().atualizar(entidade, codigo));
		
	}
	
	
}
