package br.com.recanto.terapia.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.recanto.terapia.exceptionhandler.PessoaInexistenteOuInativa;
import br.com.recanto.terapia.model.SuperPojo;
import br.com.recanto.terapia.negocio.regra.RegraNegocioPessoa;

@Service("usuarioService")
@Qualifier("usuarioService")
public class UsuarioService<T> extends GenericService<T>{
	
	@Autowired
	private RegraNegocioPessoa validacaoRegraPessoa;

	@Override
	public SuperPojo atualizar(SuperPojo entidade, Integer codigo) {
		this.dao.setPersistentClass(this.persistentClass);
		SuperPojo pojo  =  this.dao.findOne(codigo);
		if (pojo == null || validarSituacaoPessoa(pojo)) {
			throw new PessoaInexistenteOuInativa();
		}
		BeanUtils.copyProperties(entidade, pojo, "id");

		return super.atualizar(entidade, codigo);
	}

	private boolean validarSituacaoPessoa(SuperPojo pojo) {
		return this.validacaoRegraPessoa.validarSituacao(pojo);
	}
}
