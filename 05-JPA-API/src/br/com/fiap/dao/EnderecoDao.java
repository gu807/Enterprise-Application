package br.com.fiap.dao;

import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EnderecoNotFoundException;
import br.com.fiap.entity.Endereco;

public interface EnderecoDao {

	
	void create(Endereco endereco);
	
	Endereco search(int id) throws EnderecoNotFoundException;
	
	void update(Endereco endereco);
	
	void delete(int id) throws EnderecoNotFoundException;
	
	void commit() throws CommitException;
	
}
