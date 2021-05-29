package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Carro extends Veiculo {

	@Column(name = "nr_portas")
	private Integer numeroPortas;
	
	@Column(name = "qt_lugares")
	private Integer qtdLugares;
	
	public Carro() {}
	
	public Carro(String modelo, String placa, Integer numeroPortas, Integer qtdLugares) {
		super(modelo, placa);
		this.numeroPortas = numeroPortas;
		this.qtdLugares = qtdLugares;
	}



	public Integer getNumeroPortas() {
		return numeroPortas;
	}

	public void setNumeroPortas(Integer numeroPortas) {
		this.numeroPortas = numeroPortas;
	}

	public Integer getQtdLugares() {
		return qtdLugares;
	}

	public void setQtdLugares(Integer qtdLugares) {
		this.qtdLugares = qtdLugares;
	}
	
	
	
}
