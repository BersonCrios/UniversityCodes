package br.com.gfe.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.gfe.factory.JPAFactory;
import br.com.gfe.model.EntradaFinanceira;
import br.com.gfe.model.SaidaFinanceira;
import br.com.gfe.repository.EntradaFinanceiraRepository;
import br.com.gfe.repository.SaidaFinanceiraRepository;
import br.unitins.frame.application.Util;

@ManagedBean
@ViewScoped
public class RelatorioSaidasFinanceirasController {
	private List<SaidaFinanceira> listaSaida;

	public List<SaidaFinanceira> getListaSaida() {
		if (listaSaida == null) {
			SaidaFinanceiraRepository repository = new SaidaFinanceiraRepository(JPAFactory.getEntityManager());
			listaSaida = repository.bucarTodos();
		}
		return listaSaida;
	}

	public void setListaSaida(List<SaidaFinanceira> listaSaida) {
		this.listaSaida = listaSaida;
	}
	
	
	public void imprimir() {
		Util.redirectNewPage("saidaFinanceira");
	}
}
