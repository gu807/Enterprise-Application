package br.com.fiap.view;


import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

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
		
		/*//foreach
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

		System.out.println("--------------------------------------------------------");
		//Buscar pacotes por preço menor, obtendo uma lista de vetor de objetos
		pacDao.buscaPorPrecoMenor(10000).forEach(p -> System.out.println(p[0] + " " + p[1]));
		
		System.out.println("--------------------------------------------------------");
		//Buscar pacotes por preço menor, obtendo uma lista de vetor de pacotes
		pacDao.buscaPorPrecoMenor2(10000).forEach(p -> System.out.println(p.getDescricao() + " " + p.getQtdDias() + " " + p.getPreco()));
		
		//Buscar a descrição de pacotes por preço menor, obtendo uma lista de vetor de String
		System.out.println("--------------------------------------------------------");
		pacDao.buscaPorPrecoMenor3(10000).forEach(p -> System.out.println(p));

		System.out.println("--------------------------------------------------------");
		pacDao.buscarPorDatas(new GregorianCalendar(2019, 3, 20), new GregorianCalendar(2022, 3, 20)).forEach(p -> System.out.println(p.toString()));
		
		System.out.println("--------------------------------------------------------");
		cliDao.buscar("a", "a").forEach(c -> System.out.println(c.getNome() + " - " + c.getEndereco().getCidade().getNome()));
		
		System.out.println("--------------------------------------------------------");
		List<String> lista = new ArrayList<String>();
		lista.add("SP");
		lista.add("BA");
		
		cliDao.buscarPorEstados(lista).forEach(c -> System.out.println(c.getNome() + " - " + c.getEndereco().getCidade().getUf()));
		*/
		
		cliDao.buscarPorNome2("a").forEach(c -> System.out.println(c.getNome()));
		
		System.out.println(cliDao.quantidadePorEstado("BA"));
		
		Transporte t = traDao.pesquisar(1);
		
		System.out.println(pacDao.somaPacoteTransporte(t));
		
		//fechando a conexão
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
		
		
	}//main

}//classe
