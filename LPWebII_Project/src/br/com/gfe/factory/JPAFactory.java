package br.com.gfe.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAFactory {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestorFinanceiroEclesiastico");
	
	private JPAFactory() {}
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
