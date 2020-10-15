package br.com.gfe.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.gfe.model.Membro;
import br.unitins.frame.repository.Repository;

public class MembroRepository extends Repository<Membro> {

	public MembroRepository(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<Membro> getModelClass() {
		return Membro.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Membro> bucarTodos() {
		
		Query query = geEntityManager().createQuery("Select m From Membro m Order by m.id Desc");
		List<Membro> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<Membro>();
		
		return lista;

	}
}
