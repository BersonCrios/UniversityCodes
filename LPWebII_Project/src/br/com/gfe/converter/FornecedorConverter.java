package br.com.gfe.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.gfe.factory.JPAFactory;
import br.com.gfe.model.Fornecedor;
import br.com.gfe.model.Fornecedor;
import br.com.gfe.model.Fornecedor;
import br.com.gfe.repository.FornecedorRepository;
import br.com.gfe.repository.FornecedorRepository;
import br.unitins.frame.application.ApplicationException;

@FacesConverter(value = "fornecedorConverter", forClass = Fornecedor.class)
public class FornecedorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		FornecedorRepository repository = new FornecedorRepository(JPAFactory.getEntityManager());
		try {
			Fornecedor f = ((Fornecedor) repository.find(Integer.parseInt(arg2)));
			return f;
		} catch (NumberFormatException | ApplicationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 != null) {
			return ((Fornecedor) arg2).getId() == null ? "" : ((Fornecedor) arg2).getId().toString();
		}
		return "";
	}

}