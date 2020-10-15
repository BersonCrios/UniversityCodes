package br.com.gfe.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import br.com.gfe.model.PessoaFisica;
import br.unitins.frame.repository.Repository;

public class PessoaFisicaRepository extends Repository<PessoaFisica> {

	public PessoaFisicaRepository(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<PessoaFisica> getModelClass() {
		return PessoaFisica.class;
	}

	@SuppressWarnings("unchecked")
	public List<PessoaFisica> bucarTodos() {
		
		Query query = geEntityManager().createQuery("Select pf From PessoaFisica pf Order by pf.id Desc");
		List<PessoaFisica> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<PessoaFisica>();
		
		return lista;

	}
}
