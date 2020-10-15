package br.com.gfe.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.gfe.model.Usuario;
import br.unitins.frame.repository.Repository;

public class UsuarioRepository extends Repository<Usuario> {

	public UsuarioRepository(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<Usuario> getModelClass() {
		return Usuario.class;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> bucarTodos() {

		Query query = geEntityManager().createQuery("Select u From Usuario u Order by u.id Desc");
		List<Usuario> lista = query.getResultList();

		if (lista == null)
			lista = new ArrayList<Usuario>();

		return lista;

	}
	
	public Usuario buscarUsuarioPorCPF(String CPF) {
		TypedQuery<Usuario> query = geEntityManager().createQuery("SELECT u FROM Usuario u WHERE u.cpf = :CPF", Usuario.class);
		
		return query.setParameter("CPF", CPF).getSingleResult();
	}
}
