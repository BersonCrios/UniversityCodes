package br.com.gfe.reports;

import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.servlet.annotation.WebServlet;

import br.com.gfe.factory.JPAFactory;

@WebServlet("/saidasFinanceira")
public class SaidaFinanceiraReportServlet extends ReportServlet {


	private static final long serialVersionUID = 6240453864318260988L;

	@Override
	public String getArquivoJasper() {
		return "saidasFinanceiras.jasper";
	}

	@Override
	public HashMap<String, Class<?>> getParametros() {
		HashMap<String, Class<?>> param = new HashMap<String, Class<?>>();
		return param;
	}

	@Override
	public EntityManager getEntityManager() {
		return JPAFactory.getEntityManager();
	}
	
   
}