package br.com.agr.validation;

import java.util.ArrayList;
import java.util.List;

import br.com.agr.model.Pessoa;
import br.unitins.frame.application.ValidationException;
import br.unitins.frame.validation.Validation;

public class PessoaValidation implements Validation<Pessoa>{

	List<String> listMessages;
	
	@Override
	public void validate(Pessoa p) throws ValidationException {
		
		if (p.getNome() == null || p.getNome().equals(""))
			getlistMessages().add("O nome deve ser informado!");
		
		if (p.getTelefone() == null || p.getNome().equals(""))
			getlistMessages().add("O telefone deve ser informado!");
		
		if (getlistMessages().size() > 0)
			throw new ValidationException(getlistMessages());
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
