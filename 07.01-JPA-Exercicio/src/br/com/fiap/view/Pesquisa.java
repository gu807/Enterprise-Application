package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.SistemaDao;
import br.com.fiap.tds.dao.impl.SistemaDaoImpl;
import br.com.fiap.tds.entity.CasoTeste;
import br.com.fiap.tds.entity.ItemTeste;
import br.com.fiap.tds.entity.Sistema;
import br.com.fiap.tds.entity.Usuario;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Pesquisa {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		SistemaDao sDao = new SistemaDaoImpl(em);

		try {
			Sistema sistema = sDao.search(4);
			System.out.println(sistema.getNome());
			for (CasoTeste caso : sistema.getCasos()) {
				System.out.println(caso.getNome());
				for (ItemTeste teste : caso.getItens()) {
					System.out.println(teste.getDescricao());
					for (Usuario usuario : teste.getUsuarios()) {
						System.out.println(usuario.getNome());
					}
				}
			}
			
		} catch (EntityNotFoundException e ) {
			System.out.println(e.getMessage());
		}
	
	em.close();
	EntityManagerFactorySingleton.getInstance().close();
	}
	
	//Fechar
			

	
}
