package br.com.fiap.tds.ex.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_PACIENTE")
@SequenceGenerator(name = "paciente", allocationSize = 1, sequenceName = "SQ_TB_PACIENTE")
public class Paciente {
	
	@Id
	@GeneratedValue(generator = "paciente" , strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_paciente")
	private int codigo;
	
	@Column(name = "nm_paciente", nullable = false, length = 80)
	private String nome;
	
	@Column(name = "dt_nascimento")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar nascimento;
	
	@OneToMany(mappedBy = "paciente")
	private List<Consulta> consultas;
	
	public Paciente() {
		// TODO Auto-generated constructor stub
	}

	public Paciente( String nome, Calendar nascimento) {
	
		this.nome = nome;
		this.nascimento = nascimento;
		
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

	public Calendar getNascimento() {
		return nascimento;
	}

	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}
	
	
	
	
	
	

}
