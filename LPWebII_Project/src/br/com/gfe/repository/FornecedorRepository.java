package br.com.gfe.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.gfe.model.Fornecedor;
import br.unitins.frame.repository.Repository;

public class FornecedorRepository extends Repository<Fornecedor> {

	public FornecedorRepository(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<Fornecedor> getModelClass() {
		return Fornecedor.class;
	}

	@SuppressWarnings("unchecked")
	public List<Fornecedor> bucarTodos() {

		Query query = geEntityManager().createQuery("Select f From Fornecedor f Order by f.id Desc");
		List<Fornecedor> lista = query.getResultList();

		if (lista == null)
			lista = new ArrayList<Fornecedor>();

		return lista;

	}

	public List<Fornecedor> buscarFornecedores(String nome) {

		Query query = geEntityManager().createQuery("SELECT f FROM Fornecedor f WHERE f.nome LIKE ?1 ORDER BY f.nome");
		query.setParameter(1, "%" + nome + "%");
		List<Fornecedor> lista = query.getResultList();

		if (lista == null)
			lista = new ArrayList<Fornecedor>();

		return lista;
	}
}
