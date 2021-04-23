package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Table(name="TB_EMPRESA")
@SequenceGenerator(name="empresa", sequenceName = "SQ_T_EMPRESA", allocationSize = 1)
//sequenceName -> nome no banco de dados
//name -> nome no java
//allocationsSize -> incremento

public class Empresa {

	@Id
	@Column(name="cd_empresa")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empresa")
	private int cd;
	
	@Column(name="nm_empresa", nullable = false, length = 100)
	private String nome;
	
	@Column(name="nr_cnpj", nullable = false, length = 30, updatable = false)
	private String cnpj;
	
	@Column(name="nr_funcionarios" )
	private int qtdFunc;
	
	@Column(name="ds_endereco", length = 200)
	private String end;
	
	@Temporal(TemporalType.DATE) // Armazena somente a data
	@Column(name="dt_fundacao", nullable = false)
	private Calendar dataFundacao;
	
	@Transient // não será uma coluna no banco de dados
	private int anosVida;
	
	@Lob //BLOB no oracle, para gravar arquivos
	@Column(name="fl_logo")
	private byte[] Logo;
	
	@Column(name="ds_tipo", length = 10)
	@Enumerated(EnumType.STRING)
	private tipoEmpresa tipo;

	public int getCd() {
		return cd;
	}

	public void setCd(int cd) {
		this.cd = cd;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public int getQtdFunc() {
		return qtdFunc;
	}

	public void setQtdFunc(int qtdFunc) {
		this.qtdFunc = qtdFunc;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public Calendar getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Calendar dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public int getAnosVida() {
		return anosVida;
	}

	public void setAnosVida(int anosVida) {
		this.anosVida = anosVida;
	}

	public byte[] getLogo() {
		return Logo;
	}

	public void setLogo(byte[] logo) {
		Logo = logo;
	}

	public tipoEmpresa getTipo() {
		return tipo;
	}

	public void setTipo(tipoEmpresa tipo) {
		this.tipo = tipo;
	}
	
	
	
}
