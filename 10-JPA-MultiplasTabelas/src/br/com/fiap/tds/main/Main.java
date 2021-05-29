package br.com.fiap.tds.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.FuncionarioDao;
import br.com.fiap.tds.dao.impl.FuncionarioDaoImpl;
import br.com.fiap.tds.entity.Funcionario;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Main {
	
	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		FuncionarioDao dao = new FuncionarioDaoImpl(em);
		
		Funcionario func = new Funcionario("Gustavo", new GregorianCalendar(2021, Calendar.MAY, 27), 20000.0, 1231, 123);

		
		try {
			dao.create(func);
			dao.commit();
			System.out.println("Sucesso!!!!");
		} catch (CommitException e) {
			e.getMessage();
		}
		
		
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}

}
