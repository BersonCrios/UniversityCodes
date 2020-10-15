package br.com.gfe.validation;

import java.util.ArrayList;
import java.util.List;

import br.com.gfe.model.Pessoa;
import br.unitins.frame.application.ValidationException;
import br.unitins.frame.validation.Validation;

public class PessoaValidation implements Validation<Pessoa> {
	
	List<String> listMessages;

	@Override
	public void validate(Pessoa t) throws ValidationException {
		if (t.getNome() == null || t.getNome().trim().equals("")){
			getlistMessages().add("O nome deve ser informado!");
		}
		
		if (t.getEndereco() == null || t.getEndereco().trim().equals("")){
			getlistMessages().add("O endereço deve ser informada!");
		}
		
		if (t.getTelefone() == null || t.getTelefone().trim().equals("")){
			getlistMessages().add("O telefone deve ser informada!");
		}
		
		if (t.getEmail() == null || t.getEmail().trim().equals("")){
			getlistMessages().add("O email deve ser informada!");
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
