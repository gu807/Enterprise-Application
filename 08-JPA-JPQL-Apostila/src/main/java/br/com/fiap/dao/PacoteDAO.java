package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public interface PacoteDAO extends GenericDAO<Pacote,Integer>{

		List<Pacote> buscarTransporte(Transporte transporte);

		//Buscar por preço menor, retornando a descrição e a qtd de dias(List<Object[]>)
		List<Object[]> buscaPorPrecoMenor(float preco);
		
		//Buscar por preço menos, retornando a descrição e a qtd de dias (List<Pacote>)
		List<Pacote> buscaPorPrecoMenor2(float preco);
		
		//Buscar por preço menor, retornando a descrição (List<String>)
		List<String> buscaPorPrecoMenor3(float preco);
		
		List<Pacote> buscarPorDatas(Calendar inicio, Calendar fim);
		
		Double somaPacoteTransporte(Transporte transporte);

		
		//Utilizando query nativa
		//Buscar por quantidade de dias maior e preço menor
		List<Pacote> buscarPorQtdDiasMaiorEPrecoMenor(int dias, float preco); 
}



