package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.CasoTesteDao;
import br.com.fiap.tds.entity.CasoTeste;

public class CasoTesteDaoImpl extends GenericDaoImpl<CasoTeste, Integer> implements CasoTesteDao {

	public CasoTesteDaoImpl(EntityManager em) {
		super(em);
	}

}
