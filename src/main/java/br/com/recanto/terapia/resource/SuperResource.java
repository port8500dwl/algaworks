package br.com.recanto.terapia.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.recanto.terapia.service.GenericService;

@Component
public class SuperResource<SuperPojo> {

	@Autowired
	@Qualifier("genericService")
	private GenericService<SuperPojo> entidadeService;

	public GenericService<SuperPojo> getEntidadeService() {
		return entidadeService;
	}

	public void setEntidadeService(GenericService<SuperPojo> entidadeService) {
		this.entidadeService = entidadeService;
	}
	
	
}
