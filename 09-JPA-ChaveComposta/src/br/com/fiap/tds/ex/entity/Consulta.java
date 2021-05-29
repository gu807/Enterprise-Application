package br.com.fiap.tds.ex.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@IdClass(ConsultaPK.class)

@Entity
@Table(name = "TB_CONSULTA")
public class Consulta {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "nr_crm")
	private Medico medico;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "cd_paciente")
	private Paciente paciente;

	@Id
	@Column(name = "dt_consulta")
	private Calendar date;
	
	@Column(name = "st_retorno", nullable = false)
	private boolean retorno;
	
	@Column(name = "ds_consulta")
	private String descricao;
	
	public Consulta() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Consulta(Medico medico, Paciente paciente, Calendar date, boolean retorno, String descricao) {
		this.medico = medico;
		this.paciente = paciente;
		this.date = date;
		this.retorno = retorno;
		this.descricao = descricao;
	}



	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public boolean isRetorno() {
		return retorno;
	}

	public void setRetorno(boolean retorno) {
		this.retorno = retorno;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
