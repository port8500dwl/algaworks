package br.com.recanto.terapia.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import br.com.recanto.terapia.model.Profissao;
import br.com.recanto.terapia.repository.ProfissaoRepository;
import br.com.recanto.terapia.service.GenericService;

@RestController
@RequestMapping("/profissao")
public class ProfissaoResource {

	@Autowired
	private ProfissaoRepository repositorEntidade;

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	@Qualifier("genericService")
	private GenericService<Profissao> entidadeService; 
	
	
	@GetMapping
	public ResponseEntity<?> listar(){
		List<Profissao> lista = this.repositorEntidade.findAll();
		return !lista.isEmpty() ? ResponseEntity.ok(lista) : ResponseEntity.noContent().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Profissao> criar(@Valid @RequestBody Profissao entidade, HttpServletResponse response) {
		Profissao novoRegistro = (Profissao) this.repositorEntidade.save(entidade);
		this.publisher.publishEvent(new RecursoCriadoEvento(this, response, novoRegistro.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(novoRegistro);
	}
	
	@GetMapping("{codigo}")
	public ResponseEntity<?> recuperarPeloCodigo(@PathVariable Integer codigo) {
		Profissao entidade = (Profissao) this.repositorEntidade.findOne(codigo);
		return entidade != null ? ResponseEntity.ok(entidade) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Integer codigo) {
		this.repositorEntidade.delete(codigo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<?> atualizar(@PathVariable Integer codigo, @Valid @RequestBody Profissao entidade) {
		this.entidadeService.setPersistentClass(Profissao.class);
		return ResponseEntity.ok(this.entidadeService.atualizar(entidade, codigo));
	}	
	
}