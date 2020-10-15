package br.com.gfe.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.com.gfe.factory.JPAFactory;
import br.com.gfe.model.Fornecedor;
import br.com.gfe.model.SaidaFinanceira;
import br.com.gfe.model.TipoRecurso;
import br.com.gfe.repository.FornecedorRepository;
import br.com.gfe.repository.SaidaFinanceiraRepository;
import br.com.gfe.util.Report;
import br.com.gfe.validation.SaidaFinanceiraValidation;
import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;


@ManagedBean
@ViewScoped
public class SaidaFinanceiraController extends Controller<SaidaFinanceira> {
	private List<SaidaFinanceira> listaSaidaFinanceira;
	private List<Fornecedor> listaFornecedor;
	
	//Variável que referência o relatório que será gerado
		private Report relatorio;
	
		
		//Método que gera o relatório 
		public Report getRelatorio() {
			if (relatorio == null) 
				relatorio = new Report("jdbc/gfe", "reports", "saidasFinanceiras");
			return relatorio;
		}
		
	@Override
	public SaidaFinanceira getEntity() {
		if (entity == null) {
			entity = new SaidaFinanceira();
		}
		return entity;
	}

	@Override
	public void clean(ActionEvent actionEvent) {
		super.clean(actionEvent);
		setListaSaidaFinanceira(null);
	}
	
	@Override
	public Validation<SaidaFinanceira> getValidation() {
		return new SaidaFinanceiraValidation();
	}
	
	@Override
	protected EntityManager getEntityManager() {
		return JPAFactory.getEntityManager();
	}

	public List<SaidaFinanceira> getListaSaidaFinanceira() {
		if (listaSaidaFinanceira == null) {
			SaidaFinanceiraRepository repository = new SaidaFinanceiraRepository(JPAFactory.getEntityManager());
			listaSaidaFinanceira = repository.bucarTodos();
		}
		return listaSaidaFinanceira;
	}

	public void setListaSaidaFinanceira(List<SaidaFinanceira> listaSaidaFinanceira) {
		this.listaSaidaFinanceira =  listaSaidaFinanceira;
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
	
	
	public TipoRecurso[] getTipoRecurso() {
		return TipoRecurso.values();
	}
}
