package br.com.fiap.view;


import javax.persistence.EntityManager;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Transporte;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Main {
	
	public static void main(String[] args) {
		
		//Obter um entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar os daos para obter os metodos
		CidadeDAO cidadeDAO = new CidadeDAOImpl(em);
		ClienteDAO cliDao = new ClienteDAOImpl(em);
		PacoteDAO pacDao = new PacoteDAOImpl(em);
		TransporteDAO traDao = new TransporteDAOImpl(em);
		
		//foreach
		System.out.println("--------------------------------------------------------");
		//listar todas as cidade
		cidadeDAO.listar().forEach(l -> System.out.println(l.toString())); 
			
		System.out.println("--------------------------------------------------------");
		//Listar todas as cidades por determinado ddd
		cidadeDAO.listaPorDDD(14).forEach(l -> System.out.println(l.toString()));
		
		System.out.println("--------------------------------------------------------");
		//listar todos os clientes por determinado dias de reserva
		cliDao.buscarPorDiasReserva(10).forEach(l -> System.out.println(l.toString()));
		
		System.out.println("--------------------------------------------------------");
		Transporte transporte = traDao.pesquisar(1);
		//listar todos os pacoter feitos por determinado transporte
		pacDao.buscarTransporte(transporte).forEach(p -> System.out.println(p.toString()));
		
		System.out.println("--------------------------------------------------------");
		//listar cidades passando o valor maximo da pagina e em que posição estará
		cidadeDAO.listar(0, 2).forEach(c -> System.out.println(c.toString()));

		//fechando a conexão
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
		
		
	}//main

}//classe
