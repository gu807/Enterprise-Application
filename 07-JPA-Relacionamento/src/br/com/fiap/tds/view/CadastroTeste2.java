package br.com.fiap.tds.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GrupoChallengeDao;
import br.com.fiap.tds.dao.ProjetoChallengeDao;
import br.com.fiap.tds.dao.impl.GrupoChallengeDaoImpl;
import br.com.fiap.tds.dao.impl.ProjetoChallengeDaoImpl;
import br.com.fiap.tds.entity.GrupoChallenge;
import br.com.fiap.tds.entity.ProjetoChallenge;
import br.com.fiap.tds.entity.TipoProjeto;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroTeste2 {

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
				
		projeto.setGrupo(grupo);
		
		//Cadastrar o projeto
		//Sempre que utilizar um atributo com mappedBy para o persist em cascade
		//Precisamos setar o atributo que mapeia a FK no banco (outro lado da relação)
		pdao.create(projeto);
		
		//Cadastrar o grupo
		//gdao.create(grupo);
		
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
