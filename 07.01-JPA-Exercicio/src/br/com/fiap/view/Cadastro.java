package br.com.fiap.view;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.SistemaDao;
import br.com.fiap.tds.dao.impl.SistemaDaoImpl;
import br.com.fiap.tds.entity.CasoTeste;
import br.com.fiap.tds.entity.ItemTeste;
import br.com.fiap.tds.entity.Sistema;
import br.com.fiap.tds.entity.Usuario;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Cadastro {

	public static void main(String[] args) {
		
		//Instanciar um sistema
		
		Sistema sistema = new Sistema("Windows");
		
		//Instanciar dois casos de testes
		
		//Adicionar os casos de teste no sistema
		CasoTeste caso1 = new CasoTeste("aaaa", "aaaa");
		CasoTeste caso2 = new CasoTeste("bbbb", "bbbb");
		
		sistema.addCaso(caso1);
		sistema.addCaso(caso2);
		//instanciar 3 itens de teste
		
		// Adicionar 2 itens no primeiro caso e 1 item no segundo 
		ItemTeste item1 = new ItemTeste("qualquer");
		ItemTeste item2 = new ItemTeste("coisa");
		ItemTeste item3 = new ItemTeste("fodase");
		
		caso1.addItem(item1);
		caso1.addItem(item2);
		caso2.addItem(item3);
		
		//Instanciar 2 usuarios

		Usuario usuario1 = new Usuario("Gustavo");
		Usuario usuario2 = new Usuario("Henrique");
		
		//Criar uma lista de usuario e adiciona-los na lista
		
		List<Usuario> listUser = new ArrayList<>();
		
		listUser.add(usuario1);
		listUser.add(usuario2);
		
		//Setar em dois itens a lista de usuario
		
		item1.setUsuarios(listUser);
		item3.setUsuarios(listUser);
		
		//Obter um entity manager 
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		//Instanciar um SistemaDao
		SistemaDao sDao = new SistemaDaoImpl(em);
		
		//Cadastrar o sistema
		try {
			sDao.create(sistema);
			sDao.commit();
		} catch (CommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
	
	
}
