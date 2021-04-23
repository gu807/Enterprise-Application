package br.com.fiap.tds.main;

import br.com.fiap.tds.bean.Funcionario;
import br.com.fiap.tds.bean.Genero;

public class TesteEnum {

	public static void main(String[] args) {
		//instanciar um funcionario
		Funcionario func = new Funcionario("Gustavo",18);	
		//Atribuir um valor para o genero do ususario
		
		func.setDeficiente(true);
		
		func.setGenero(Genero.MASCULINO);
		
		//Validar se o genero é feminino
		
		if (func.getGenero() == Genero.FEMININO) {
			System.out.println(func.getGenero());
		}else {
			System.out.println("genero masculino");
		}
		
		
		//Exibir genero
	}
	
}
