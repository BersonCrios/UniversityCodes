package br.com.gfe.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import br.com.gfe.factory.JPAFactory;
import br.com.gfe.model.Usuario;
import br.com.gfe.repository.UsuarioRepository;
import br.unitins.frame.application.Session;
import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;

@ManagedBean
@ViewScoped
public class perfilController extends Controller<Usuario> {

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
	
	public Usuario getUsuarioLogado() {
		  if (Session.getSessionScope().get("usuarioLogado") == null) {
	            UsuarioRepository repo = new UsuarioRepository(JPAFactory.getEntityManager());
	            FacesContext context = FacesContext.getCurrentInstance();
	            ExternalContext external = context.getExternalContext();
	            Usuario usuarioLogado;
	            usuarioLogado = repo.buscarUsuarioPorCPF(external.getRemoteUser());
	            Session.getSessionScope().put("usuarioLogado", usuarioLogado);
	            return usuarioLogado;
	        } else {
	            return (Usuario) Session.getSessionScope().get("usuarioLogado");
	        }
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	@Override
	public Validation<Usuario> getValidation() {
		return null;
	}

}
