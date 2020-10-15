package br.com.gfe.listController;

import java.util.ArrayList;
import java.util.List;

import br.com.gfe.factory.JPAFactory;
import br.com.gfe.model.Fornecedor;
import br.com.gfe.repository.FornecedorRepository;
import br.unitins.frame.listController.ListController;
import br.unitins.frame.repository.Repository;

public class FornecedorListController extends ListController<Fornecedor> {

	private static final long serialVersionUID = 4128490746879406996L;
	
	public FornecedorListController() {
		super(new FornecedorRepository(JPAFactory.getEntityManager()), true, false, false, 450, 650,
				"/listings/listagemFornecedor");
		getEntity().setNome("");
	}


	@Override
	public Fornecedor getEntity() {
		if (entity == null) 
			entity = new Fornecedor();
		return entity;
	}

	@Override
	public List<Fornecedor> getListEntity() {
		if (listEntity == null) {
			listEntity = new ArrayList<Fornecedor>();
			FornecedorRepository repository = new FornecedorRepository(JPAFactory.getEntityManager());
			try {
				listEntity = repository.buscarFornecedores(getEntity().getNome());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listEntity;
	}

}
