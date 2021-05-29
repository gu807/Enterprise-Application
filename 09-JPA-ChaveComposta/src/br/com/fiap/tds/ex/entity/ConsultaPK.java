package br.com.fiap.tds.ex.entity;

import java.io.Serializable;
import java.util.Calendar;

public class ConsultaPK implements Serializable {

	private int medico;
	
	private int paciente;
	
	private Calendar date;
	
	public ConsultaPK() {
		// TODO Auto-generated constructor stub
	}

	public ConsultaPK(int medico, int paciente, Calendar date) {
		super();
		this.medico = medico;
		this.paciente = paciente;
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + medico;
		result = prime * result + paciente;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsultaPK other = (ConsultaPK) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (medico != other.medico)
			return false;
		if (paciente != other.paciente)
			return false;
		return true;
	}

	public int getMedico() {
		return medico;
	}

	public void setMedico(int medico) {
		this.medico = medico;
	}

	public int getPaciente() {
		return paciente;
	}

	public void setPaciente(int paciente) {
		this.paciente = paciente;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}
	
	
	
	
}
