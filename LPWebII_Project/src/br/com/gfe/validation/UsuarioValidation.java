package br.com.gfe.validation;

import java.util.ArrayList;
import java.util.List;

import br.com.gfe.model.Usuario;
import br.unitins.frame.application.ValidationException;
import br.unitins.frame.validation.Validation;

public class UsuarioValidation implements Validation<Usuario> {
	
	List<String> listMessages;

	@Override
	public void validate(Usuario t) throws ValidationException {
		if (t.getSenha() == null || t.getSenha().trim().equals("")){
			getlistMessages().add("Uma senha deve ser informada!");
		}
		
		if (t.getPermissao() == null || t.getPermissao().equals("")){
			getlistMessages().add("O tipo de permissão deve ser informada!");
		}
		
		if (getlistMessages().size() > 0){
			throw new ValidationException(getlistMessages());
		}
	}
	public List<String> getlistMessages() {
		if (listMessages == null)
			listMessages = new ArrayList<String>();
		return listMessages;
	}

	public void setlistMessages(List<String> listMessages) {
		this.listMessages = listMessages;
	}
}
