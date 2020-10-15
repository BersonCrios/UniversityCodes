package br.com.gfe.validation;

import java.util.ArrayList;
import java.util.List;

import br.com.gfe.model.EntradaFinanceira;
import br.unitins.frame.application.ValidationException;
import br.unitins.frame.validation.Validation;

public class EntradaFinanceiraValidation implements Validation<EntradaFinanceira> {
	
	List<String> listMessages;

	@Override
	public void validate(EntradaFinanceira ef) throws ValidationException {
		if (ef.getValor() == null || ef.getValor().equals("")){
			getlistMessages().add("Um valor da entrada financeira deve ser informado!");
		}
		
		if (ef.getData() == null || ef.getData().equals("")){
			getlistMessages().add("A data deve ser informada para esta entrada!");
		}
		
		if (ef.getRecurso() == null || ef.getRecurso().equals("")){
			getlistMessages().add("O tipo de recurso deve ser informada!");
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
