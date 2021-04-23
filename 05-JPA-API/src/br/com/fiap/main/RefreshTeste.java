package br.com.fiap.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Endereco;

public class RefreshTeste {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();
		
		Endereco end = em.find(Endereco.class, 1);
		
		System.out.println(end);
		
		end.setNumeroEnd(55);
		end.setLogradouro("av Paulista");
		
		System.out.println(end);
		
		em.refresh(end);
		
		System.out.println(end);
		
		
		em.close();
		fabrica.close();
		
	}
	
}
