package br.com.recanto.terapia.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pessoaService")
@Qualifier("pessoaService")
public class PessoaService<T> extends GenericService<T>{
}
