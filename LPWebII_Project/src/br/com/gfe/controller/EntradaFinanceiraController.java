package br.com.gfe.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.com.gfe.factory.JPAFactory;
import br.com.gfe.model.EntradaFinanceira;
import br.com.gfe.model.Membro;
import br.com.gfe.repository.MembroRepository;
import br.com.gfe.util.Report;
import br.com.gfe.model.TipoRecurso;
import br.com.gfe.repository.EntradaFinanceiraRepository;
import br.com.gfe.validation.EntradaFinanceiraValidation;
import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;

@ManagedBean
@ViewScoped
public class EntradaFinanceiraController extends Controller<EntradaFinanceira> {
	private List<EntradaFinanceira> listaEntradaFinanceira;
	private List<Membro> listaMembro;
	
	//Variável que referência o relatório que será gerado
	private Report relatorio;

	//Método que gera o relatório 
	public Report getRelatorio() {
		if (relatorio == null) 
			relatorio = new Report("jdbc/gfe", "reports", "entradasFinanceira");
		return relatorio;
	}
	
	
	@Override
	public EntradaFinanceira getEntity() {
		if (entity == null) {
			entity = new EntradaFinanceira();
			entity.setMembro(new Membro());
		}
		return entity;
	}

	@Override
	public void clean(ActionEvent actionEvent) {
		super.clean(actionEvent);
		setListaEntradaFinanceira(null);
		setListaMembro(null);
	}

	@Override
	public Validation<EntradaFinanceira> getValidation() {
		return new EntradaFinanceiraValidation();
	}

	@Override
	protected EntityManager getEntityManager() {
		return JPAFactory.getEntityManager();
	}

	public List<EntradaFinanceira> getListaEntradaFinanceira() {
		if (listaEntradaFinanceira == null) {
			EntradaFinanceiraRepository repository = new EntradaFinanceiraRepository(JPAFactory.getEntityManager());
			listaEntradaFinanceira = repository.bucarTodos();
		}
		return listaEntradaFinanceira;
	}

	public void setListaEntradaFinanceira(List<EntradaFinanceira> listaEntradaFinanceira) {
		this.listaEntradaFinanceira = listaEntradaFinanceira;
	}

	public List<Membro> getListaMembro() {
		if (listaMembro == null) {
			MembroRepository repository = new MembroRepository(JPAFactory.getEntityManager());
			listaMembro = repository.bucarTodos();
		}
		return listaMembro;
	}

	public void setListaMembro(List<Membro> listaMembro) {
		this.listaMembro = listaMembro;
	}

	public TipoRecurso[] getTipoRecurso() {
		return TipoRecurso.values();
	}
	

}
