package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.entity.Cidade;

public class CidadeDAOImpl extends GenericDAOImpl<Cidade,Integer> implements CidadeDAO{

	public CidadeDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cidade> listar() {
		//Criar a query
		return em.createQuery("from Cidade", Cidade.class)
		//Configurar o máximo de resultado para 2
			.setMaxResults(2)
				.getResultList();
	}

	@Override
	public List<Cidade> listaPorDDD(int ddd) {
		return em.createQuery("from Cidade c where c.ddd = :ddd", Cidade.class)
				.setParameter("ddd", ddd)
					.getResultList();
	}

}
