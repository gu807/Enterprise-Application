package br.com.fiap.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Teste {
	
	public static void main(String[] args) {
		
		//Obter uma fabrica de entityManager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		//Obter um objeto que gerencia as entidades EntityManager
		EntityManager em = fabrica.createEntityManager();
		
		//fechar
		em.close();
		fabrica.close();
		
	}

}
