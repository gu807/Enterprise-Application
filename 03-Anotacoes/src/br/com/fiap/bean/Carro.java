package br.com.fiap.bean;

import br.com.fiap.annotation.Coluna;


public class Carro {

	@Coluna(nome = "ds_cor", tipo= "VARCHAR2", tamanho = 30)
	private String cor;
	@Coluna(nome = "ds_modelo", tipo= "VARCHAR2")
	private String modelo;
	@Coluna(nome = "nr_ano", tipo= "NUMBER")
	private int ano;

	public Carro() {
	}
	
	public Carro(String cor, String modelo, int ano) {
		this.cor = cor;
		this.modelo = modelo;
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	
	
	
}
