package br.com.gfe.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.com.gfe.factory.JPAFactory;
import br.com.gfe.model.Ativo;
import br.com.gfe.model.EstadoCivil;
import br.com.gfe.model.Membro;
import br.com.gfe.model.TipoMembro;
import br.com.gfe.repository.MembroRepository;
import br.com.gfe.validation.MembroValidation;
import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;


@ManagedBean
@ViewScoped
public class MembroController extends Controller<Membro> {
	private List<Membro> listaMembro;

	@Override
	public Membro getEntity() {
		if (entity == null) {
			entity = new Membro();
		}
		return entity;
	}

	@Override
	public void clean(ActionEvent actionEvent) {
		super.clean(actionEvent);
		setListaMembro(null);
	}
	
	@Override
	public Validation<Membro> getValidation() {
		return new MembroValidation();
	}
	
	@Override
	protected EntityManager getEntityManager() {
		return JPAFactory.getEntityManager();
	}

	public List<Membro> getListaMembro() {
		if (listaMembro == null) {
			MembroRepository repository = new MembroRepository(JPAFactory.getEntityManager());
			listaMembro = repository.bucarTodos();
		}
		return listaMembro;
	}

	public void setListaMembro(List<Membro> listaMembro) {
		this.listaMembro =  listaMembro;
	}
	
	public TipoMembro[] getTipoMembro(){
		return TipoMembro.values();
	}
	
	public EstadoCivil[] getEstadoCivil(){
		return EstadoCivil.values();
	}

}
