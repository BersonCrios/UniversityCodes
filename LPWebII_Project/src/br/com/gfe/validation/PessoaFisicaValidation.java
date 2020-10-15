package br.com.gfe.validation;

import java.util.ArrayList;
import java.util.List;

import br.com.gfe.model.PessoaFisica;
import br.unitins.frame.application.ValidationException;
import br.unitins.frame.validation.Validation;

public class PessoaFisicaValidation implements Validation<PessoaFisica> {
	
	List<String> listMessages;

	@Override
	public void validate(PessoaFisica t) throws ValidationException {
		if (t.getCpf() == null || t.getCpf().trim().equals("")){
			getlistMessages().add("O CPF deve ser informado!");
		}
		
		if (t.getRg() == null || t.getRg().trim().equals("")){
			getlistMessages().add("O RG deve ser informada!");
		}
		
		if (t.getFiliacao() == null || t.getFiliacao().trim().equals("")){
			getlistMessages().add("O pai ou mãe deve ser informada!");
		}
		if (t.getDataNascimento() == null || t.getDataNascimento().equals("")){
			getlistMessages().add("A data de nascimento deve ser informada!");
		}
		
		if (t.getEstadoCivil() == null || t.getEstadoCivil().equals("")){
			getlistMessages().add("O estado cívil deve ser informada!");
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
