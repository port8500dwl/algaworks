package br.com.recanto.terapia.negocio.regra;

import org.springframework.stereotype.Component;

import br.com.recanto.terapia.model.SuperPojo;
import br.com.recanto.terapia.model.Usuario;

@Component
public class RegraNegocioPessoa {

	public boolean validarSituacao(SuperPojo pojo) {
		boolean retorno = false;
		Usuario usuario= (Usuario) pojo;
		if (usuario.getPessoa() != null && usuario.getPessoa().getAtivo().intValue() !=0) {
			retorno = Boolean.TRUE;
		}
		return retorno;
	}

}
