package br.com.fiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GrupoChallengeDao;
import br.com.fiap.tds.dao.impl.GrupoChallengeDaoImpl;
import br.com.fiap.tds.entity.Aluno;
import br.com.fiap.tds.entity.GrupoChallenge;
import br.com.fiap.tds.entity.NanoCourse;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class PesquisaTeste {

	
	public static void main(String[] args) {
		
		//Obter um entityManager
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter um GrupoChallengeDao
		
		GrupoChallengeDao gdao = new GrupoChallengeDaoImpl(em);
		
		//Pesquisar um grupo
		
		try {
			GrupoChallenge gc = gdao.search(2);
			//Exibir o nome do grupo
			System.out.println(gc.getName());
			//Exibir o nome do projeto
			System.out.println(gc.getProjeto().getName());
			
			for (Aluno aluno: gc.getAlunos()) {
				System.out.println("nome: " + aluno.getName());
				System.out.println("Cursos: ");
				for (NanoCourse nano : aluno.getCursos()) {
					System.out.println(nano.getName());
				}
				//Exibir os cursos dos alunos
			}
			
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
	
}
