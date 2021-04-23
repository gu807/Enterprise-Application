package br.com.fiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GenericDao;
import br.com.fiap.tds.dao.impl.GenericDaoImpl;
import br.com.fiap.tds.entity.Cliente;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class ClienteDaoTeste {

	public static void main(String[] args) {
		//Obter um Enitty Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		//Obter uma instância de GenericDao para o cliente
		//Definir uma classe anônima e obter a instancia
		GenericDao<Cliente, Integer> dao = new GenericDaoImpl<Cliente, Integer>(em) {};
		
		//Cadastrar
		Cliente cliente = new Cliente("Gustavo", "659844884", true);		
		try {
			dao.create(cliente);
			dao.commit();
		} catch (CommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//pesquisar
		try {
			System.out.println(dao.search(1));
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
		}
		
		
		//fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}
	
	
	
}
