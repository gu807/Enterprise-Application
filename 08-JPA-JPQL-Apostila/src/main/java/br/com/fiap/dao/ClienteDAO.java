package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer>{
	
	List<Cliente> buscarPorNome(String nome);
	
	List<Cliente> buscarPorUf(String uf);
	
	List<Cliente> buscarPorDiasReserva(int reservaDias);

}
