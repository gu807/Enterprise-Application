package br.com.fiap.tds.dao;

import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.exception.CommitException;

//GenericDao<Cliente> dao = ...

public interface GenericDao<E, K> {

	void create(E entidade);
	
	E search(K id) throws EntityNotFoundException;
	
	void update(E entidade);
	
	void delete(K id) throws EntityNotFoundException;
	
	void commit() throws CommitException;
	
}
