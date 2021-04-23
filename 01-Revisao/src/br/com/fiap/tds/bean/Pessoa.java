package br.com.fiap.tds.bean;

public class Pessoa {

	// Modificadores de acessos:
	// private -> apenas a propria classe tem acesso
	// protected -> todos do pacote e classe filhas
	// public -> todos
	// default (package) -> todos do pacote

	//Tipos primitivos; byte, short, int, long, float, double 
	//Valor padrão: números = , boolean = false; 
	
	//Tipos de referencia (Classes): String, Pessoa, Funcionario, Departamento
	//Valor padrão: null 
	
	// Atributos
	private String nome;

	private int idade;
	
	private boolean deficiente;
	
	private Genero genero;
	
	//Construtores
	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	public Pessoa(String nome, int idade, boolean deficiente) {
		this.nome = nome;
		this.idade = idade;
		this.deficiente = deficiente;
	}
	
	public Pessoa() {}
	// Métodos

	
	public void cadastrar() {
		System.out.println("Cadastrando uma pessoa...");
		
	}
	
	//Sobrecarga -> mesmo método com parâmetros diferentes
	public void cadastrar(String nome) {
		System.out.println("Cadastrando o/a " + nome);
	}
	
	public void cadastrar(String nome, int idade) {
		System.out.println("Cadastrando com nome e idade");
	}
	
	
	public boolean isDeficiente() {
		return deficiente;
	}

	public void setDeficiente(boolean deficiente) {
		this.deficiente = deficiente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	

}
