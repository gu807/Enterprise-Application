package br.com.br.fiap.tds.dao;

import br.com.fiap.tds.bean.Funcionario;

public interface FuncionarioDao {
	
	void atualizar(Funcionario funcionario);
	
	void deletar(int id);

}
