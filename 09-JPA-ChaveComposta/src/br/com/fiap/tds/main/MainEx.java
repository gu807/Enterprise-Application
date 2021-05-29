package br.com.fiap.tds.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.ConsultaDao;
import br.com.fiap.tds.dao.impl.ConsultaDaoImpl;
import br.com.fiap.tds.ex.entity.Consulta;
import br.com.fiap.tds.ex.entity.Medico;
import br.com.fiap.tds.ex.entity.Paciente;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class MainEx {
	
	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		ConsultaDao dao = new ConsultaDaoImpl(em);
		
		Medico medico = new Medico(2565, "Dr Gustavo");
		
		Paciente paciente = new Paciente("Jose", new GregorianCalendar(1999, Calendar.JANUARY, 31));
		
		Consulta consulta = new Consulta(medico, paciente, new GregorianCalendar(2021, Calendar.AUGUST, 27), false, null);
		
		try {
			dao.create(consulta);
			dao.commit();
			System.out.println("Sucesso");
		} catch (CommitException e) {
			e.getMessage();
		}
		
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}

	
	
}
