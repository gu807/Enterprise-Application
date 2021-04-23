package br.com.fiap.tds.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.fiap.tds.bean.Funcionario;

public class TesteColecao {
	public static void main(String[] args) {
		
	
	List<Funcionario> lista = new ArrayList<>();
	
	lista.add(new Funcionario("Cleiton", 20));
	
	Funcionario func = new Funcionario("Lucas", 20);
	lista.add(func);
	
	
	for (Funcionario funcionario : lista) {
		System.out.println(funcionario);
	}
	
	for (int i = 0; i < lista.size(); i++) {
		System.out.println(lista.get(i).getNome() + " " + lista.get(i).getIdade());
	}
	
	Map<String, Funcionario> mapa = new HashMap<String, Funcionario>();
			
	mapa.put("a", new Funcionario("Vinicius", 19));	
	mapa.put("b", new Funcionario("Gustavo", 21));
	
	
	func = mapa.get("a");
	System.out.println(func);
	
	
	}

}
