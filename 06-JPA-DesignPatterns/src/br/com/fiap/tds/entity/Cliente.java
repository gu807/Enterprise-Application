package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CLIENTE")
@SequenceGenerator(name = "cliente", allocationSize = 1, sequenceName = "SQ_TB_CLIENTE")
public class Cliente {
	
	@Id
	@Column(name = "cd_cliente", nullable = false)
	@GeneratedValue(generator = "cliente", strategy = GenerationType.SEQUENCE)
	private int cd;
	
	@Column(name = "nm_cliente", nullable = false, length = 50)
	private String name;
	
	@Column(name = "nr_cpf", length = 22, nullable = false)
	private String cpf;
	
	@Column(name = "st_ativo")
	private boolean ativo;

	
	public Cliente() {
	}
	
	public Cliente(String name, String cpf, boolean ativo) {
		this.name = name;
		this.cpf = cpf;
		this.ativo = ativo;
	}

	public Cliente(int cd, String name, String cpf, boolean ativo) {
		this.cd = cd;
		this.name = name;
		this.cpf = cpf;
		this.ativo = ativo;
	}
	
	@Override
	public String toString() {
		return "Cliente [cd=" + cd + ", name=" + name + ", cpf=" + cpf + ", ativo=" + ativo + "]";
	}

	public int getCd() {
		return cd;
	}

	public void setCd(int cd) {
		this.cd = cd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	
	
	
	
}
