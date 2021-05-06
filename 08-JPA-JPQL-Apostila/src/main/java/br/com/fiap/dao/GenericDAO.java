package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntityNotFoundException;

public interface GenericDAO<T,K> {

	List<T> listar(int primeiraPos, int maximoResul);
	List<T> listar();
	void cadastrar(T entity);
	void alterar(T entity);
	void remover(K codigo) throws EntityNotFoundException;
	T pesquisar(K codigo);
	void salvar() throws CommitException;
	
}
