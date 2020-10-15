package br.com.gfe.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.com.gfe.factory.JPAFactory;
import br.com.gfe.listController.FornecedorListController;
import br.com.gfe.model.Fornecedor;
import br.com.gfe.repository.FornecedorRepository;
import br.com.gfe.validation.FornecedorValidation;
import br.unitins.frame.application.SelectionListener;
import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;

@ManagedBean
@ViewScoped
public class FornecedorController extends Controller<Fornecedor> {
	private List<Fornecedor> listaFornecedor;

	@Override
	public Fornecedor getEntity() {
		if (entity == null) {
			entity = new Fornecedor();
		}
		return entity;
	}

	@Override
	public void clean(ActionEvent actionEvent) {
		super.clean(actionEvent);
		setListaFornecedor(null);
	}

	@Override
	public Validation<Fornecedor> getValidation() {
		return new FornecedorValidation();
	}

	@Override
	protected EntityManager getEntityManager() {
		return JPAFactory.getEntityManager();
	}

	public void abrirListFornecedor(ActionEvent actionEvent) {
		FornecedorListController list = new FornecedorListController();
		list.openList(new SelectionListener<Fornecedor>() {
			@Override
			public void select(Fornecedor entity) {
				setEntity(entity);
			}
		});
	}

	public List<Fornecedor> getListaFornecedor() {
		if (listaFornecedor == null) {
			FornecedorRepository repository = new FornecedorRepository(JPAFactory.getEntityManager());
			listaFornecedor = repository.bucarTodos();
		}
		return listaFornecedor;
	}

	public void setListaFornecedor(List<Fornecedor> listaFornecedor) {
		this.listaFornecedor = listaFornecedor;
	}

}
