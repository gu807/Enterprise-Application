package br.com.fiap.orm;

import br.com.fiap.annotation.Tabela;
import br.com.fiap.bean.Aluno;

public class ORM {

	public String buscar(Aluno aluno) {
		Tabela t = aluno.getClass().getAnnotation(Tabela.class);
		return "SELECT * FROM " + t.nome(); 
	};
	
}
