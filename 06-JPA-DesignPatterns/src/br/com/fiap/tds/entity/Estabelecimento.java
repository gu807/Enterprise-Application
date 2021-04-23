package br.com.fiap.tds.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ESTABELECIMENTO")
@SequenceGenerator(name = "estabelecimento", allocationSize = 1, sequenceName = "SQ_TB_ESTABELECIMENTO")
public class Estabelecimento {

	@Id
	@Column(name = "cd_estabelecimento", nullable = false)
	@GeneratedValue(generator = "estabelecimento", strategy = GenerationType.SEQUENCE)
	private int cd;
	
	@Column(name = "nm_estabelecimento", length = 70, nullable = false)
	private String name;
	
	@Column(name = "nr_cnpj", length = 22, nullable = false)
	private String cnpj;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ds_tipo", length = 20)
	private TipoEstabelecimento tipo;

	
	public Estabelecimento() {
	}
	
	public Estabelecimento(String name, String cnpj, TipoEstabelecimento tipo) {
		this.name = name;
		this.cnpj = cnpj;
		this.tipo = tipo;
	}

	public Estabelecimento(int cd, String name, String cnpj, TipoEstabelecimento tipo) {
		this.cd = cd;
		this.name = name;
		this.cnpj = cnpj;
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return "Código: " + cd + "\nNome: " + name + "\nCnpj: " + cnpj + "\nTipo Estabelecimento: " + tipo;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public TipoEstabelecimento getTipo() {
		return tipo;
	}

	public void setTipo(TipoEstabelecimento tipo) {
		this.tipo = tipo;
	}
	
	
	
}
