package br.com.gfe.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.gfe.factory.JPAFactory;
import br.com.gfe.model.Caixa;
import br.com.gfe.model.EntradaFinanceira;
import br.com.gfe.model.Membro;
import br.com.gfe.validation.CaixaValidation;
import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;

@ManagedBean
@ViewScoped
public class CaixaController extends Controller<Caixa> {

	@Override
	protected EntityManager getEntityManager() {
		return JPAFactory.getEntityManager();
	}

	@Override
	public Caixa getEntity() {
		if (entity == null) {
			entity = new Caixa();
		}
		return entity;
	}

	@Override
	public Validation<Caixa> getValidation() {

		return new CaixaValidation();
	}

}
