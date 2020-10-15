package br.com.gfe.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.gfe.factory.JPAFactory;
import br.com.gfe.model.Membro;
import br.com.gfe.repository.MembroRepository;
import br.unitins.frame.application.ApplicationException;

@FacesConverter(value = "membroConverter", forClass = Membro.class)
public class MembroConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		MembroRepository repository = new MembroRepository(JPAFactory.getEntityManager());
		try {
			Membro m = ((Membro) repository.find(Integer.parseInt(arg2)));
			return m;
		} catch (NumberFormatException | ApplicationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 != null) {
			return ((Membro) arg2).getId() == null ? "" : ((Membro) arg2).getId().toString();
		}
		return "";
	}

}
