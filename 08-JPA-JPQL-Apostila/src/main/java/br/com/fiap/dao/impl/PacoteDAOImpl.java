package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class PacoteDAOImpl extends GenericDAOImpl<Pacote,Integer> implements PacoteDAO{

	public PacoteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Pacote> buscarTransporte(Transporte transporte) {
		return em.createQuery("from Pacote p where p.transporte = :trans", Pacote.class)
				.setParameter("trans", transporte)
					.getResultList();
	}

	@Override
	public List<Object[]> buscaPorPrecoMenor(float preco) {
		return em.createQuery("select p.descricao, p.qtdDias from Pacote p where p.preco < :p", Object[].class)
				.setParameter("p", preco)
				.getResultList();
	}

	@Override
	public List<Pacote> buscaPorPrecoMenor2(float preco) {
		return em.createQuery("select new Pacote(p.descricao, p.qtdDias) from Pacote p where p.preco < :p", Pacote.class)
				.setParameter("p", preco)
				.getResultList();
	}

	@Override
	public List<String> buscaPorPrecoMenor3(float preco) {
		return em.createQuery("select p.descricao from Pacote p where p.preco < :p", String.class)
				.setParameter("p", preco)
				.getResultList();
	}

	@Override
	public List<Pacote> buscarPorDatas(Calendar inicio, Calendar fim) {
		return em.createQuery("from Pacote p where p.dataSaida between :i and :f", Pacote.class)
				.setParameter("i", inicio)
				.setParameter("f", fim)
				.getResultList();
	}

	@Override
	public Double somaPacoteTransporte(Transporte transporte) {
		return em.createQuery("select sum(p.preco) from Pacote p where p.transporte =:t", Double.class)
				.setParameter("t", transporte)
				.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pacote> buscarPorQtdDiasMaiorEPrecoMenor(int dias, float preco) {
		return em.createNativeQuery("SELECT * FROM TB_EAD_PACOTE WHERE QT_DIAS > :d AND VL_PACOTE < :p", Pacote.class)
				.setParameter("d", dias)
				.setParameter("p", preco)
					.getResultList();
	}

}
