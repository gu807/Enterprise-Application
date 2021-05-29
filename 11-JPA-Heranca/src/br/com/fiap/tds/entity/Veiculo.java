package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

@Entity
@Table(name = "TB_VEICULO")
@SequenceGenerator(name = "veiculo", allocationSize = 1, sequenceName = "SQ_TB_VEICULO")
public class Veiculo {
	
	@Id
	@Column(name = "cd_veiculo")
	@GeneratedValue(generator = "veiculo", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "ds_modelo", nullable = false, length = 50)
	private String modelo;
	
	@Column(name = "ds_placa", length = 10)
	private String placa;
	
	public Veiculo() {}
	
	public Veiculo(String modelo, String placa) {
		this.modelo = modelo;
		this.placa = placa;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	

}
