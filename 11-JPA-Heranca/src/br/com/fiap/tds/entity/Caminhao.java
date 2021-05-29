package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Caminhao extends Veiculo{

	@Column(name = "ds_carroceria")
	private String carroceria;
	
	@Column(name = "qt_eixo")
	private Integer qtdEixo;
	
	public Caminhao() {
	}

	
	public Caminhao(String modelo, String placa, String carroceria, Integer qtdEixo) {
		super(modelo, placa);
		this.carroceria = carroceria;
		this.qtdEixo = qtdEixo;
	}



	public String getCarroceria() {
		return carroceria;
	}

	public void setCarroceria(String carroceria) {
		this.carroceria = carroceria;
	}

	public Integer getQtdEixo() {
		return qtdEixo;
	}

	public void setQtdEixo(Integer qtdEixo) {
		this.qtdEixo = qtdEixo;
	}
	
	
	
}
