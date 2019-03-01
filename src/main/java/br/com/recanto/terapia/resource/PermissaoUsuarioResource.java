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
import br.com.recanto.terapia.filter.PermissaoFilter;
import br.com.recanto.terapia.model.PermissaoUsuario;
import br.com.recanto.terapia.repository.usuario.permissao.PermissaoUsuarioRepository;

@RestController
@RequestMapping("/permissaoUsuario")
public class PermissaoUsuarioResource extends SuperResource<PermissaoUsuario>{

	@Autowired
	private PermissaoUsuarioRepository permissaoRepository;

	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public ResponseEntity<?> pesquisar(PermissaoFilter filter){
		List<PermissaoUsuario> lista = this.permissaoRepository.filtrar(filter);
		return !lista.isEmpty() ? ResponseEntity.ok(lista) : ResponseEntity.noContent().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<PermissaoUsuario> criar(@Valid @RequestBody PermissaoUsuario entidade, HttpServletResponse response) {
		PermissaoUsuario novoRegistro = this.permissaoRepository.save(entidade);
		this.publisher.publishEvent(new RecursoCriadoEvento(this, response, novoRegistro.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(novoRegistro);
	}
	
	@GetMapping("{codigo}")
	public ResponseEntity<PermissaoUsuario> recuperarPeloCodigo(@PathVariable Integer codigo) {
		PermissaoUsuario entidade = (PermissaoUsuario) this.permissaoRepository.getOne(codigo);
		return entidade != null ? ResponseEntity.ok(entidade) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Integer codigo) {
		this.getEntidadeService().delete(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<?> atualizar(@PathVariable Integer codigo, @Valid @RequestBody PermissaoUsuario entidade) {
		super.getEntidadeService().setPersistentClass(PermissaoUsuario.class);
		return ResponseEntity.ok(super.getEntidadeService().atualizar(entidade, codigo));
	}

	
}
