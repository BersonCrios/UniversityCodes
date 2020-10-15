package br.com.gfe.validation;

import java.util.ArrayList;
import java.util.List;

import br.com.gfe.model.Membro;
import br.unitins.frame.application.ValidationException;
import br.unitins.frame.validation.Validation;

public class MembroValidation implements Validation<Membro> {

	List<String> listMessages;

	@Override
	public void validate(Membro m) throws ValidationException {
		if (m.getDataEntrada() == null || m.getDataEntrada().equals("")) {
			getlistMessages().add("Uma data de entrada da pessoa como membro deve ser informada!");
		}

		if (m.getTipoMembro() == null || m.getTipoMembro().equals("")) {
			getlistMessages().add("Informe o Tipo de membro!");
		}

		if (getlistMessages().size() > 0) {
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
