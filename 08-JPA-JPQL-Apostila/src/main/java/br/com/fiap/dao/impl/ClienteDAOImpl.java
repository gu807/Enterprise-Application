package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente,Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> buscarPorNome(String nome) {
		return em.createQuery("from Cliente c where c.nome like :pnome", Cliente.class)
				.setParameter("pnome", "%" + nome + "%")
					.getResultList();
	}

	@Override
	public List<Cliente> buscarPorUf(String uf) {
		return em.createQuery("from Cliente c where c.endereco.cidade.uf = :pUf", Cliente.class)
			.setParameter("pUf", uf)
				.getResultList();
	}

	@Override
	public List<Cliente> buscarPorDiasReserva(int dias) {
		return em.createQuery("select r.cliente from Reserva r where r.numeroDias = :d", Cliente.class)
				.setParameter("d", dias)
					.getResultList();
	}

	@Override
	public List<Cliente> buscar(String nome, String cidade) {
		return em.createQuery("from Cliente c where c.nome like :n and c.endereco.cidade.nome like :ci", Cliente.class)
				.setParameter("n", "%" + nome + "%")
				.setParameter("ci", "%" + cidade + "%")
					.getResultList();
	}

	@Override
	public List<Cliente> buscarPorEstados(List<String> estados) {
		return em.createQuery("from Cliente c where c.endereco.cidade.uf in :a", Cliente.class)
				.setParameter("a", estados)
					.getResultList();
	}

	@Override
	public List<Cliente> buscarPorNome2(String nome) {
		return em.createQuery("from Cliente c where lower(c.nome) like lower(:pnome) order by c.nome desc", Cliente.class)
				.setParameter("pnome", "%" + nome + "%")
					.getResultList();
	}

	@Override
	public Long quantidadePorEstado(String uf) {
		return em.createQuery("select count(*) from Cliente c where c.endereco.cidade.uf =:u", Long.class)
				.setParameter("u", uf).getSingleResult();
	}

}
