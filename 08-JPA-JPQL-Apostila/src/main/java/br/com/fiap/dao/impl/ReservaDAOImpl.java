package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.entity.Reserva;

public class ReservaDAOImpl extends GenericDAOImpl<Reserva,Integer> implements ReservaDAO {

	public ReservaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Reserva> buscaPorDias(int dias) {
	
		return em.createQuery("from Reserva r where r.numeroDias = :pdias", Reserva.class)
				.setParameter("pdias", dias)
					.getResultList();
		
	}

	@Override
	public List<Reserva> buscarPorNomeCliente(String nome) {
		return em.createNamedQuery("Reserva.porNomeCliente", Reserva.class)
				.setParameter("n", "%" + nome + "%")
					.getResultList();
	}

	@Override
	public List<Reserva> buscarPorDiasNamedQuery(int dias) {
		return em.createNamedQuery("Reserva.porDias", Reserva.class)
				.setParameter("d", dias)
					.getResultList();
	}

	
	
}
