package br.com.recanto.terapia.repository.usuario.permissao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.util.StringUtils;

import br.com.recanto.terapia.filter.PermissaoFilter;
import br.com.recanto.terapia.model.PermissaoUsuario;

public class PermissaoUsuarioRepositoryImpl implements PermissaoUsuarioRepositoryQuery{

	@PersistenceContext
	private EntityManager entityManager;	
	
	@Override
	public List<PermissaoUsuario> filtrar(PermissaoFilter filter) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<PermissaoUsuario> criteria = builder.createQuery(PermissaoUsuario.class); 
		Root<PermissaoUsuario> root = criteria.from(PermissaoUsuario.class);
		
		Predicate[] preticates = criarRestricoes(filter, builder, root);
		//criar as restrições
		criteria.where(preticates);
		
		TypedQuery<PermissaoUsuario> query = entityManager.createQuery(criteria);
 		return query.getResultList();
	}

	
	private Predicate[] criarRestricoes(PermissaoFilter filter, CriteriaBuilder builBuilder, Root<PermissaoUsuario> root) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if (!StringUtils.isEmpty(filter.getNome())) {
			predicates.add(builBuilder.like(builBuilder.lower(root.get("nome")), "'%"+filter.getNome().toLowerCase()+"%'"));
		}
		
		if (filter.getDataCadastroDe() != null) {
			predicates.add(builBuilder.greaterThanOrEqualTo(root.get("dataCadastro"), filter.getDataCadastroDe()));
		}
		if (filter.getDataCadastroA() != null) {
			predicates.add(builBuilder.lessThan(root.get("dataCadastro"), filter.getDataCadastroA()));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}	
}
