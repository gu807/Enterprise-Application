package br.com.fiap.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Endereco;

public class PesquisaTeste {
	
	public static void main(String[] args) {
		
		//Obter uma fabrica de entityManager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		//Obter um objeto que gerencia as entidades EntityManager
		EntityManager em = fabrica.createEntityManager();
		
		Endereco end = em.find(Endereco.class, 2);
		
		System.out.println(end);
		
		end.setCep("27153213");
		
		em.getTransaction().begin();
		
		em.getTransaction().commit();
		
		
		//fechar
		em.close();
		fabrica.close();
		
	}
	

}
