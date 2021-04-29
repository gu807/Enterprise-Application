package br.com.fiap.tds.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GenericDao;
import br.com.fiap.tds.dao.GrupoChallengeDao;
import br.com.fiap.tds.dao.impl.GenericDaoImpl;
import br.com.fiap.tds.dao.impl.GrupoChallengeDaoImpl;
import br.com.fiap.tds.entity.Aluno;
import br.com.fiap.tds.entity.GrupoChallenge;
import br.com.fiap.tds.entity.NanoCourse;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroTeste3 {
	
	public static void main(String[] args) {
		//1 - Cadastrar um aliuno com um grupo que já existe no banco
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		GenericDao<Aluno, Integer> aDao = new GenericDaoImpl<Aluno, Integer>(em){}; 
		
		GenericDao<NanoCourse, Integer> nDao = new GenericDaoImpl<NanoCourse, Integer>(em){}; 
		
		GrupoChallengeDao gdao = new GrupoChallengeDaoImpl(em);
		
		Aluno aluno = new Aluno("João", new GregorianCalendar(2001, Calendar.AUGUST, 26), "Estagiário");
		
		
		GrupoChallenge gp;
		try {
			gp = gdao.search(1);
			aluno.setGrupo(gp);
			aDao.create(aluno);
			aDao.commit();
			
			System.out.println("Aluno cadastrado");
		} catch (EntityNotFoundException | CommitException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		try {
			NanoCourse nano = nDao.search(1);
			Aluno a = aDao.search(1);
			
			List<NanoCourse> lista = a.getCursos();
			lista.add(nano);
			
			aDao.update(a);
			aDao.commit();
			
			
		} catch (EntityNotFoundException | CommitException e) {
			e.printStackTrace();
		}
		
		
		//2 - Associar um aluno À um curso que já existem 
		
		
		
	}
	
}
