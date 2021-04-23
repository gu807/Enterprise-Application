package br.com.fiap.tds.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "TB_FORNECEDOR")
@SequenceGenerator(name = "fornecedor", allocationSize = 1, sequenceName = "SQ_TB_FORNECEDOR")
public class Fornecedor {

	@Id
	@Column(name = "cd_fornecedor", nullable = false)
	@GeneratedValue(generator = "fornecedor", strategy = GenerationType.SEQUENCE)
	private int cd;
	
	@Column(name = "nm_fornecedor", length = 60, nullable = false )
	private String name;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_cadastro", updatable = false)
	private Calendar dataCadastro;
	
	public Fornecedor() {}

	public Fornecedor(String name) {
		this.name = name;
	}

	public Fornecedor(int cd, String name) {
		this.cd = cd;
		this.name = name;
	}

	@Override
	public String toString() {
		SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		return "Código: " + cd + "\nNome: " + name + "\nData de Cadastro: " + sp.format(dataCadastro.getTime());
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

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
	
}
