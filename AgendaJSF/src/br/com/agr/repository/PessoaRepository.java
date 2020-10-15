package br.com.agr.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.frame.repository.Repository;
import br.com.agr.model.Pessoa;

public class PessoaRepository extends Repository<Pessoa>{

	public PessoaRepository(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<Pessoa> getModelClass() {
		return Pessoa.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> bucarTodos() {
		
		Query query = geEntityManager().createQuery("Select p From Pessoa p Order by p.id Desc");
		List<Pessoa> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<Pessoa>();
		
		return lista;

}

}
