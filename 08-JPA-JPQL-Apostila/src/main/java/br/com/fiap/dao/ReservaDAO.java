package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Reserva;

public interface ReservaDAO extends GenericDAO<Reserva,Integer>{

	List<Reserva> buscaPorDias(int dias);
	
	List<Reserva> buscarPorNomeCliente(String nome);
	
	List<Reserva> buscarPorDiasNamedQuery(int dias);
	
	
	
}
