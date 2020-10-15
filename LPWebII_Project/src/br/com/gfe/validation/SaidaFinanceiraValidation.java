package br.com.gfe.validation;

import java.util.ArrayList;
import java.util.List;

import br.com.gfe.model.SaidaFinanceira;
import br.unitins.frame.application.ValidationException;
import br.unitins.frame.validation.Validation;

public class SaidaFinanceiraValidation implements Validation<SaidaFinanceira> {
	
	List<String> listMessages;

	@Override
	public void validate(SaidaFinanceira t) throws ValidationException {
		if (t.getNumeroDocumento() == null || t.getNumeroDocumento().trim().equals("")){
			getlistMessages().add("O Número do documento deve ser informada!");
		}
		
		if (t.getDataDoDocumento() == null || t.getDataDoDocumento().equals("")){
			getlistMessages().add("A Data do documento deve ser informada!");
		}
		
		if (t.getDataOrdemDoPagamento() == null || t.getDataOrdemDoPagamento().equals("")){
			getlistMessages().add("A data da ordem de pagamento deve ser informado!");
		}
		
		if (t.getDataPagamento() == null || t.getDataPagamento().equals("")){
			getlistMessages().add("A data do pagamento deve ser informada!");
		}
		
		if (t.getValor() == null || t.getValor().equals("")){
			getlistMessages().add("O Valor deve ser informado!");
		}
		
		if (t.getRecurso() == null || t.getRecurso().equals("")){
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
