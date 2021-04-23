package br.com.fiap.tds.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe que gerencia a �nica inst�ncia da EntityManagerFactory
 * 
 */
public class EntityManagerFactorySingleton {

	// 1 - Atributo est�tico que armazena a �nica inst�ncia
	
	private static EntityManagerFactory fabrica;
	
	// 2 - Construtor privado -> ninguem consegue instanciar 
	private EntityManagerFactorySingleton() {}
	
	// 3 - M�todo est�tico que retorna a �nica instancia
	public static EntityManagerFactory getInstance() {
		
		//validar se existe a fabrica
		if (fabrica == null) {
			fabrica = Persistence.createEntityManagerFactory("oracle");
		}
		
		return fabrica;
	}
}
