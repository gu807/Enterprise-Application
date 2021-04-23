package br.com.fiap.main;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.fiap.annotation.Coluna;
import br.com.fiap.bean.Carro;

public class Teste {

	public static void main(String[] args) {
		
		//Instanciar um carro
		
		Carro carro = new Carro();
		
		//API de reflection -> obtem a estrutura da classe
		//Obter o nome da classe 
		String nomeClasse = carro.getClass().getSimpleName();
		System.out.println(nomeClasse);
		
		// obter os metodos da classe 
		Method[] metodos = carro.getClass().getDeclaredMethods();

		//Exibir nome dos metodos
		
		for (Method m : metodos) {
			System.out.println(m.getName());
		}
		
		//Obter os atributos da classe
		
		Field[] atributos =  carro.getClass().getDeclaredFields();
		
		//Exibir o nome e o tipo de dado
		
		for (Field f : atributos) {
			System.out.println(f.getName() + " " + f.getType().getSimpleName());
			Coluna anotacao = f.getAnnotation(Coluna.class);
			
			System.out.println(anotacao.nome() + "\nTipo: " + anotacao.tipo() + "\nTamanho: " + anotacao.tamanho() + "\nPK: " 
			+ anotacao.pk());
		}
		
		
	}
	
}
