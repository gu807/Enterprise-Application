package br.com.fiap.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Endereco;
import br.com.fiap.entity.TipoEndereco;

public class AtualizacaoTeste {

	public static void main(String[] args) {
		
		//Obter uma fabrica de entityManager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		//Obter um objeto que gerencia as entidades EntityManager
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar um endereço com o código(Estado detached)
		
		Endereco end = new Endereco(1, "12877362", "rua de safado", 23, true, TipoEndereco.APARTAMENTO);
		
		//gerencia o objeto e atualiza no banco após o commit
		Endereco endGerenciado = em.merge(end);
		
		
		
		em.getTransaction().begin();
		
		em.getTransaction().commit();
		
		//fechar
		em.close();
		fabrica.close();
		
	}
	
}
