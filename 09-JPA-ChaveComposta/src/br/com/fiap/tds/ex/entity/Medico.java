package br.com.fiap.tds.ex.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_MEDICO")
public class Medico {

	
	@Id
	@Column(name = "nr_crm")
	private int codigo;
	
	@Column(name = "nm_medico", length = 100, nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "medico")
	private List<Consulta> consultas;
	
	public Medico() {
		// TODO Auto-generated constructor stub
	}

	public Medico( String nome) {
		this.nome = nome;
	}
	
	
	public Medico(int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}
	

	
	
	
	
	
}
