package br.com.fiap.tds.bean;

public class Funcionario extends Pessoa {
	
	//Construtor � herdado? N�o
	
	public Funcionario(String nome, int idade) {
		super(nome, idade);
	}
	
	public Funcionario() {
	}
	
	//Sobreescrita -> mesmo m�todo da classe filha
	@Override
	public void cadastrar() {
		System.out.println("Cadastrando um funcion�rio...");
	}

	@Override
	public String toString() {
		return "nome: " + getNome() + "; idade: " + getIdade();
	}
}
