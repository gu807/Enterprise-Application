package br.com.fiap.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "TB_ENDERECO")
@SequenceGenerator(name = "endereco", sequenceName = "SQ_TB_ENDERECO", allocationSize = 1)

public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco")
	@Column(name = "cd_endereco", nullable = false)
	private int cd;

	@Column(name = "nr_cep", nullable = false, length = 8)
	private String cep;

	@Column(name = "ds_logradouro", nullable = false, length = 50)
	private String logradouro;

	@Column(name = "nr_endereco")
	private int numeroEnd;

	@Column(name = "st_ativo")
	private boolean ativo;

	@Column(name = "ds_tipo_endereco", length = 50)
	@Enumerated(EnumType.STRING)
	private TipoEndereco tipoEnd;

	@CreationTimestamp // Cadastra a data de forma automatica
	@Column(name = "dt_cadastro", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCadastro;

	//Método que é executado automaticamente antes de um cadastro
	@PrePersist
	public void executar() {
		System.out.println("Cadastrando um endereço");
	}
	
	
	@Override
	public String toString() {
		SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		return "Código: " + cd + "\nCEP: " + cep + "\nLogradouro: " + logradouro + "\nNúmero: " + numeroEnd
				+ "\nAtivo: " + ativo + "\nTipo: " + tipoEnd + "\nData de Cadastro: " + sp.format(dataCadastro.getTime());
	}

	public Endereco() {
	}

	public Endereco(String cep, String logradouro, int numeroEnd, boolean ativo, TipoEndereco tipoEnd) {
		this.cep = cep;
		this.logradouro = logradouro;
		this.numeroEnd = numeroEnd;
		this.ativo = ativo;
		this.tipoEnd = tipoEnd;

	}
	
	

	public Endereco(int cd, String cep, String logradouro, int numeroEnd, boolean ativo, TipoEndereco tipoEnd) {
		super();
		this.cd = cd;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numeroEnd = numeroEnd;
		this.ativo = ativo;
		this.tipoEnd = tipoEnd;
	}

	public int getCd() {
		return cd;
	}

	public void setCd(int cd) {
		this.cd = cd;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumeroEnd() {
		return numeroEnd;
	}

	public void setNumeroEnd(int numeroEnd) {
		this.numeroEnd = numeroEnd;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public TipoEndereco getTipoEnd() {
		return tipoEnd;
	}

	public void setTipoEnd(TipoEndereco tipoEnd) {
		this.tipoEnd = tipoEnd;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
