package br.com.fiap.tds.main;

import br.com.br.fiap.tds.dao.FuncionarioDao;
import br.com.br.fiap.tds.dao.FuncionarioOracleDao;
import br.com.fiap.tds.bean.Funcionario;

// View(JSP) <-> Servlet <-> BO <-> DAO <-> Banco de dados

public class TesteInterface {
	
	public static void main(String[] args) {
		
		//Instanciar um objeto do tipo Funcionario
		
		FuncionarioDao dao = new FuncionarioOracleDao();

		//Chamar o método de atualizar funcionario
		dao.atualizar(new Funcionario());
	}

}
