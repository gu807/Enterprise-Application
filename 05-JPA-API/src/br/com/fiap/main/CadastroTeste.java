package br.com.fiap.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Endereco;
import br.com.fiap.entity.TipoEndereco;

public class CadastroTeste {
	
	public static void main(String[] args) {
		
		//Obter uma fabrica e um entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar um endereco sem o c�digo (Estado : novo - n�o gerenciado)
		
		Endereco end = new Endereco("87654321", "rua talarico", 96, true, TipoEndereco.CASA);
		
		//Colocar o endereco no contexto do entity manager
		em.persist(end);
		
		//Iniciar uma transa��o 
		
		em.getTransaction().begin();
		
		//commit
		em.getTransaction().commit();
		
		System.out.println("endere�o cadastrado");
		
		
		
		
		//fechar 
		em.close();
		fabrica.close();
	
	}
	
	
	
	
	
}
