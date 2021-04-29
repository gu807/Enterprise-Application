package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.ItemTesteDao;
import br.com.fiap.tds.entity.ItemTeste;

public class ItemTesteDaoImpl extends GenericDaoImpl<ItemTeste, Integer> implements ItemTesteDao {

	public ItemTesteDaoImpl(EntityManager em) {
		super(em);
	}

}
