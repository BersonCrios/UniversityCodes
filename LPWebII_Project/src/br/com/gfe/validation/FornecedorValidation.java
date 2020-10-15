package br.com.gfe.validation;

import java.util.ArrayList;
import java.util.List;

import br.com.gfe.model.Fornecedor;
import br.unitins.frame.application.ValidationException;
import br.unitins.frame.validation.Validation;

public class FornecedorValidation implements Validation<Fornecedor> {
	
	List<String> listMessages;

	@Override
	public void validate(Fornecedor t) throws ValidationException {
		if (t.getFornecedorDesde() == null || t.getFornecedorDesde().equals("")){
			getlistMessages().add("A data de inclusão do fornecedor deve ser informada!");
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
