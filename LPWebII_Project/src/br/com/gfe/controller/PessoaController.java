package br.com.gfe.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.com.gfe.factory.JPAFactory;
import br.com.gfe.model.Pessoa;
import br.com.gfe.repository.PessoaRepository;
import br.com.gfe.validation.PessoaValidation;
import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;


@ManagedBean
@ViewScoped
public class PessoaController extends Controller<Pessoa> {
	private List<Pessoa> listaPessoa;

	@Override
	public Pessoa getEntity() {
		if (entity == null) {
			entity = new Pessoa();
		}
		return entity;
	}

	@Override
	public void clean(ActionEvent actionEvent) {
		super.clean(actionEvent);
		setListaPessoa(null);
	}
	
	@Override
	public Validation<Pessoa> getValidation() {
		return new PessoaValidation();
	}
	
	@Override
	protected EntityManager getEntityManager() {
		return JPAFactory.getEntityManager();
	}

	public List<Pessoa> getListaPessoa() {
		if (listaPessoa == null) {
			PessoaRepository repository = new PessoaRepository(JPAFactory.getEntityManager());
			listaPessoa = repository.bucarTodos();
		}
		return listaPessoa;
	}

	public void setListaPessoa(List<Pessoa> listaPessoa) {
		this.listaPessoa = listaPessoa;
	}

}
