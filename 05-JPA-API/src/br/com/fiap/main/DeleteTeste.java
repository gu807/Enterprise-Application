package br.com.fiap.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Endereco;

public class DeleteTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();
		
		
		Endereco end = em.find(Endereco.class, 1);
		
		em.remove(end); 
		
		em.getTransaction().begin();
		
		em.getTransaction().commit();
		
		System.out.println("endereço removido");
		
		em.close();
		fabrica.close();
		
	}
	
}
