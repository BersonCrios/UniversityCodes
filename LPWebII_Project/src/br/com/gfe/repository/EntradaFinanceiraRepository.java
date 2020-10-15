package br.com.gfe.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.gfe.model.EntradaFinanceira;
import br.unitins.frame.repository.Repository;

public class EntradaFinanceiraRepository extends Repository<EntradaFinanceira> {

	public EntradaFinanceiraRepository(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<EntradaFinanceira> getModelClass() {
		return EntradaFinanceira.class;
	}

	@SuppressWarnings("unchecked")
	public List<EntradaFinanceira> bucarTodos() {

		Query query = geEntityManager().createQuery("Select ef From EntradaFinanceira ef Order by ef.id Desc");
		List<EntradaFinanceira> lista = query.getResultList();

		if (lista == null)
			lista = new ArrayList<EntradaFinanceira>();

		return lista;

	}

}
