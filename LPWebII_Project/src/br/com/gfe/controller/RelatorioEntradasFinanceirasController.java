package br.com.gfe.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.gfe.factory.JPAFactory;
import br.com.gfe.model.EntradaFinanceira;
import br.com.gfe.repository.EntradaFinanceiraRepository;
import br.unitins.frame.application.Util;

@ManagedBean
@ViewScoped
public class RelatorioEntradasFinanceirasController {
	private List<EntradaFinanceira> listaEntradas;

	public List<EntradaFinanceira> getListaEntradas() {
		if (listaEntradas == null) {
			EntradaFinanceiraRepository repository = new EntradaFinanceiraRepository(JPAFactory.getEntityManager());
			listaEntradas = repository.bucarTodos();
		}
		return listaEntradas;
	}

	public void setListaEntradas(List<EntradaFinanceira> listaEntradas) {
		this.listaEntradas = listaEntradas;
	}
	
	
	public void imprimir() {
		Util.redirectNewPage("entradasFinanceira");
	}

	
}
