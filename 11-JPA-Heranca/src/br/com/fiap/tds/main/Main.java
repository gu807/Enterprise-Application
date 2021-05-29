package br.com.fiap.tds.main;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.VeiculoDao;
import br.com.fiap.tds.dao.impl.VeiculoDaoImpl;
import br.com.fiap.tds.entity.Caminhao;
import br.com.fiap.tds.entity.Carro;
import br.com.fiap.tds.entity.Veiculo;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Main {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		VeiculoDao dao = new VeiculoDaoImpl(em);
		
		
		Veiculo v = new Veiculo("Renault", "12HGS13");
		
		Carro c = new Carro("Citroen", "ASDA312", 4, 5);
		
		Caminhao cami = new Caminhao("Ford", "WQUE233", "Aberta", 6);
		
		
		try {
			dao.create(v);
			dao.create(c);
			dao.create(cami);
			dao.commit();
			System.out.println("Sucesso!!!!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}
	
}
