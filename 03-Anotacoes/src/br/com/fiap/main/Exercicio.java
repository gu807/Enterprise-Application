package br.com.fiap.main;

import br.com.fiap.annotation.Tabela;
import br.com.fiap.bean.Aluno;
import br.com.fiap.orm.ORM;

public class Exercicio {

	public static void main(String[] args) {
		
		//Instanciar um aluno
		
		Aluno aluno = new Aluno();
		
		//Instanciar um orm
		
		ORM orm = new ORM();
		
		//Chamar o método gerarPesquisa e exibir o resultado
		
		System.out.println(orm.buscar(aluno));
		
	}
	
}
