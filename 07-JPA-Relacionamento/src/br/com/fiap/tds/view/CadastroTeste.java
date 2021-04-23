package br.com.fiap.tds.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GrupoChallengeDao;
import br.com.fiap.tds.dao.ProjetoChallengeDao;
import br.com.fiap.tds.dao.impl.GrupoChallengeDaoImpl;
import br.com.fiap.tds.dao.impl.ProjetoChallengeDaoImpl;
import br.com.fiap.tds.entity.Aluno;
import br.com.fiap.tds.entity.GrupoChallenge;
import br.com.fiap.tds.entity.NanoCourse;
import br.com.fiap.tds.entity.ProjetoChallenge;
import br.com.fiap.tds.entity.TipoProjeto;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroTeste {

	public static void main(String[] args) {
		
		
		//Obter um entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter um GrupoChallengeDao e ProjetoChallengeDao
		ProjetoChallengeDao pdao = new ProjetoChallengeDaoImpl(em);

		GrupoChallengeDao gdao = new GrupoChallengeDaoImpl(em);
		
		//Instanciar um Projeto
		ProjetoChallenge projeto = new ProjetoChallenge("Qualquer", "projeto qualquer", Calendar.getInstance(), new GregorianCalendar(2021, Calendar.OCTOBER, 10),TipoProjeto.TI, null);
		
		//instanciar um grupo com o projeto
		GrupoChallenge grupo = new GrupoChallenge("Orion", projeto);
				
		
		//Instanciar 3 alunos e adicionar no grupo
		
		Aluno aluno = new Aluno("Gustavo", new GregorianCalendar(2002, Calendar.AUGUST, 27), "bd");
		Aluno aluno1 = new Aluno("João", new GregorianCalendar(2002, Calendar.AUGUST, 27), "front");
		Aluno aluno2 = new Aluno("José", new GregorianCalendar(2002, Calendar.AUGUST, 27), "back");

		grupo.addAluno(aluno);
		grupo.addAluno(aluno1);
		grupo.addAluno(aluno2);
		
		//Instanciar 3 cursos
		
		NanoCourse nano1 = new NanoCourse("progamação em bd", 10, 20, "tecnologia");
		NanoCourse nano2 = new NanoCourse("front", 10, 20, "tecnologia");
		NanoCourse nano3 = new NanoCourse("python", 10, 20, "tecnologia");
		//Criar uma lista de cursos

		List<NanoCourse> lista = new ArrayList<>();
		
		lista.add(nano1);		
		lista.add(nano2);
		lista.add(nano3);
		//adicionar a lista no aluno
		aluno.setCursos(lista);
		aluno1.setCursos(lista);
		//Cadastrar o projeto
		//pdao.create(projeto);
		
		//Cadastrar o grupo
		gdao.create(grupo);
		
		//Commit
		try {
			gdao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
		
		
	}
	
}
