package br.com.fiap.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.EnderecoDao;
import br.com.fiap.dao.impl.EnderecoDaoImpl;
import br.com.fiap.entity.Endereco;
import br.com.fiap.entity.TipoEndereco;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EnderecoNotFoundException;

public class EnderecoDaoTeste {

	public static void main(String[] args) {

		// Obter o entity manager

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");

		EntityManager em = fabrica.createEntityManager();
		
		// Instanciar um EnderecoDao
		
		EnderecoDao end = new EnderecoDaoImpl(em);

		// Cadastrar um endereço
		Endereco ende = new Endereco();
		
		try {
			//end.create(new Endereco("02326548", "rua qualquer", 36, true, TipoEndereco.CASA));
			//ende = end.search(2);
			//end.update(new Endereco(2, "8965454", "meu ovo", 98, true, TipoEndereco.APARTAMENTO));
			end.delete(2);
			end.commit();
			//System.out.println(ende);
		} catch (CommitException | EnderecoNotFoundException e) {
			e.printStackTrace();
		} finally {
			// fechar
			//em.close();
			//fabrica.close();
		}
	}

}
