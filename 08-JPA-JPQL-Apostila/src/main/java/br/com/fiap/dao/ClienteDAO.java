package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer>{
	
	List<Cliente> buscarPorNome(String nome);
	
	List<Cliente> buscarPorUf(String uf);
	
	List<Cliente> buscarPorDiasReserva(int reservaDias);

	List<Cliente> buscar(String nome, String cidade);
	
	List<Cliente> buscarPorEstados(List<String>estados);
	
	//Pesquisar por nome, sem diferenciar maiúsculas e minúsculas, ordenado por nome
	List<Cliente> buscarPorNome2(String nome);
	
	Long quantidadePorEstado(String uf);
	
}
