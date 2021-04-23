package br.com.fiap.tds.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.tds.dao.EstabelecimentoDao;
import br.com.fiap.tds.dao.impl.EstabelecimentoDaoImpl;
import br.com.fiap.tds.entity.Estabelecimento;
import br.com.fiap.tds.entity.TipoEstabelecimento;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class EstabelecimentoDaoTeste {

	public static void main(String[] args) {
		
		//Obter um entity manager
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter um Dao do estabelecimento
		EstabelecimentoDao eDao = new EstabelecimentoDaoImpl(em);
		//Instanciar um estabelecimento e cadastra-lo
		Estabelecimento esta = new Estabelecimento("adolfo", "4897845648", TipoEstabelecimento.FILIAL);
		try {
			//eDao.create(esta);
			//eDao.create(new Estabelecimento("ricardo", "73832137213", TipoEstabelecimento.FILIAL));
			//eDao.create(new Estabelecimento("jose", "8923734656", TipoEstabelecimento.MATRIZ));
			
			//Pesquisar pelo código e exibir os dados
			//System.out.println(eDao.search(4));
			
			//Atualizar
			//eDao.update(new Estabelecimento(4, "qualquer", "146548484", TipoEstabelecimento.FILIAL));
			
			//Remover
			eDao.delete(5);

			//Commit
			eDao.commit();
			
			
		} catch (CommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
	
}
