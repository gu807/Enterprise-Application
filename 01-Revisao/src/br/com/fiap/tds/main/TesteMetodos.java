package br.com.fiap.tds.main;

import br.com.fiap.tds.bean.Funcionario;
import br.com.fiap.tds.bean.Pessoa;

public class TesteMetodos {
	
	public static void main(String[] args) {
		
	
	
	//Instaciar uma pessoa
	Pessoa pessoa = new Pessoa();
	
	//Chamar o método cadastro
	pessoa.cadastrar(); //pessoa

	//Instanciar um Funcionario
	Funcionario func = new Funcionario();

	//Chamar o método cadastrar()
	func.cadastrar(); //funcionario
	
	Pessoa p = new Funcionario();
	p.cadastrar(); // Funcionario
	
	//Funcionario f = new pessoa(); //Não compila
	
	}
}
