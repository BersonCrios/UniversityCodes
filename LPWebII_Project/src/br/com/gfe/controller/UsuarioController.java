package br.com.gfe.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.com.gfe.factory.JPAFactory;
import br.com.gfe.model.Ativo;
import br.com.gfe.model.EstadoCivil;
import br.com.gfe.model.Permissao;
import br.com.gfe.model.Usuario;
import br.com.gfe.repository.UsuarioRepository;
import br.com.gfe.validation.UsuarioValidation;
import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;


@ManagedBean
@ViewScoped
public class UsuarioController extends Controller<Usuario> {
	private List<Usuario> listaUsuario;
	private Usuario usuarioLogado;
	
	@Override
	protected EntityManager getEntityManager() {
		return JPAFactory.getEntityManager();
	}

	@Override
	public Usuario getEntity() {
		if (entity == null) {
			entity = new Usuario();
		}
		return entity;
	}

	@Override
	public void clean(ActionEvent actionEvent) {
		super.clean(actionEvent);
		setListaUsuario(null);
	}
	
	@Override
	public Validation<Usuario> getValidation() {
		return new UsuarioValidation();
	}

	public List<Usuario> getListaUsuario() {
		if (listaUsuario == null) {
			UsuarioRepository repository = new UsuarioRepository(JPAFactory.getEntityManager());
			listaUsuario = repository.bucarTodos();
		}
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario =  listaUsuario;
	}

	
	public Permissao[] getPermissao(){
		return Permissao.values();
	}
	
	public EstadoCivil[] getEstadoCivil(){
		return EstadoCivil.values();
	}
	
	public Ativo[] getAtivo(){
		return Ativo.values();
	}

	public Usuario getUsuarioLogado() {
		UsuarioRepository repo = new UsuarioRepository(JPAFactory.getEntityManager());

		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		usuarioLogado = repo.buscarUsuarioPorCPF(external.getRemoteUser());
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	
}
