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

@Entity
@Table(name="TB_FUNCIONARIO")
@SequenceGenerator(name="funcionario", sequenceName = "SQ_T_FUNC", allocationSize = 1)
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario")
	@Column(name="cd_func")
	private int cd;
	
	@Column(name="nm_func", length = 100, nullable = false)
	private String nome;
	
	@Column(name="ds_tipo", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoContrato tipoContrato;
	
	@Column(name = "dt_contratacao", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar dataContratacao;
	
	@Column(name="vl_salario")
	private double salario;
	
	@Lob
	@Column(name="fl_foto")
	private byte[] foto;
	
	@Column(name="ds_cargo", length = 300, nullable = false)
	private String cargo;
	
	@Column(name="st_deficiente")
	private boolean pcd;

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

	public TipoContrato getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(TipoContrato tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public Calendar getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(Calendar dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public boolean isPcd() {
		return pcd;
	}

	public void setPcd(boolean pcd) {
		this.pcd = pcd;
	}
	
	
	
}
