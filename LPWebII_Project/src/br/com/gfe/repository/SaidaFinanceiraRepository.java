package br.com.gfe.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.gfe.model.SaidaFinanceira;
import br.unitins.frame.repository.Repository;

public class SaidaFinanceiraRepository extends Repository<SaidaFinanceira> {

	public SaidaFinanceiraRepository(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<SaidaFinanceira> getModelClass() {
		return SaidaFinanceira.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<SaidaFinanceira> bucarTodos() {
		
		Query query = geEntityManager().createQuery("Select sf From SaidaFinanceira sf Order by sf.id Desc");
		List<SaidaFinanceira> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<SaidaFinanceira>();
		
		return lista;

	}
}
