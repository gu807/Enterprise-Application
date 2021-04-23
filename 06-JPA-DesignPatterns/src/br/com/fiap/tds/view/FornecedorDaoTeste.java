package br.com.fiap.tds.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.tds.dao.FornecedorDao;
import br.com.fiap.tds.dao.impl.FornecedorDaoImpl;
import br.com.fiap.tds.entity.Fornecedor;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class FornecedorDaoTeste {

	
	public static void main(String[] args) {
		
		//Obter um entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//instanciar um dao fornecedor
		
		FornecedorDao fDao = new FornecedorDaoImpl(em);
		
		//Instanciar um fornecedor
		Fornecedor forn = new Fornecedor("fodase");
		
		try {
			
			//Criar um fornecedor no banco
			//fDao.create(forn);
			//fDao.create(new Fornecedor("China"));
			//fDao.create(new Fornecedor("Brasil"));
			
			//pesquisar
			//System.out.println(fDao.search(2));
			
			//Atualizar
			//fDao.update(new Fornecedor(1, "argentina"));
			
			//Deletar 
			fDao.delete(1);
			
			//commit
			fDao.commit();
		
		} catch (CommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
		
	}
	
	
}
