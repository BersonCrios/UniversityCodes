package br.com.gfe.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.com.gfe.factory.JPAFactory;
import br.com.gfe.model.PessoaFisica;
import br.com.gfe.repository.PessoaFisicaRepository;
import br.com.gfe.validation.PessoaFisicaValidation;
import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;


@ManagedBean
@ViewScoped
public class PessoaFisicaController extends Controller<PessoaFisica> {
	private List<PessoaFisica> listaPessoaFisica;

	@Override
	public PessoaFisica getEntity() {
		if (entity == null) {
			entity = new PessoaFisica();
		}
		return entity;
	}

	@Override
	public void clean(ActionEvent actionEvent) {
		super.clean(actionEvent);
		setListaPessoaFisica(null);
	}
	
	@Override
	public Validation<PessoaFisica> getValidation() {
		return new PessoaFisicaValidation();
	}
	
	@Override
	protected EntityManager getEntityManager() {
		return JPAFactory.getEntityManager();
	}

	public List<PessoaFisica> getListaPessoaFisica() {
		if (listaPessoaFisica == null) {
			PessoaFisicaRepository repository = new PessoaFisicaRepository(JPAFactory.getEntityManager());
			listaPessoaFisica = repository.bucarTodos();
		}
		return listaPessoaFisica;
	}

	public void setListaPessoaFisica(List<PessoaFisica> listaPessoaFisica) {
		this.listaPessoaFisica =  listaPessoaFisica;
	}

}
