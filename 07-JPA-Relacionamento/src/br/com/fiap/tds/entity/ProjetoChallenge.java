/**
 * 
 */
package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Gustavo
 *
 */
@Entity
@Table(name = "TB_PROJETO_CHALLENGE")
@SequenceGenerator(name = "projeto", allocationSize = 1, sequenceName = "SQ_TB_PROJETO_CHALLENGE")
public class ProjetoChallenge {

	@Id
	@Column(name = "cd_projeto", nullable = false)
	@GeneratedValue(generator = "projeto", strategy = GenerationType.SEQUENCE)
	private int cd;
	
	@Column(name = "nm_projeto", nullable = false, length = 60 )
	private String name;
	
	@Column(name = "ds_projeto", length = 400)
	private String description;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_inicio", nullable = false)
	private Calendar dataStart;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_fim", nullable = false)
	private Calendar dateEnd;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ds_tipo")
	private TipoProjeto tipo;
	
	@Column(name = "vl_nota")
	private Float valorNota;
	
	//Mapear o relacionamento 1 - 1 BIDIRECIONAL
	@OneToOne(mappedBy = "projeto", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private GrupoChallenge grupo;
	
	
	
	public ProjetoChallenge() {
	}
	

	public ProjetoChallenge(int cd, String name, String description, Calendar dataStart, Calendar dateEnd,
			TipoProjeto tipo, Float valorNota) {
		this.cd = cd;
		this.name = name;
		this.description = description;
		this.dataStart = dataStart;
		this.dateEnd = dateEnd;
		this.tipo = tipo;
		this.valorNota = valorNota;
	}

	public ProjetoChallenge(String name, String description, Calendar dataStart, Calendar dateEnd, TipoProjeto tipo, Float valorNota) {
		this.name = name;
		this.description = description;
		this.dataStart = dataStart;
		this.dateEnd = dateEnd;
		this.tipo = tipo;
		this.valorNota = valorNota;
	}

	
	
	@Override
	public String toString() {
		return "ProjetoChallenge [cd=" + cd + ", name=" + name + ", description=" + description + ", dataStart="
				+ dataStart + ", dateEnd=" + dateEnd + ", tipo=" + tipo + ", valorNota=" + valorNota + "]";
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getDataStart() {
		return dataStart;
	}

	public void setDataStart(Calendar dataStart) {
		this.dataStart = dataStart;
	}

	public Calendar getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Calendar dateEnd) {
		this.dateEnd = dateEnd;
	}

	public TipoProjeto getTipo() {
		return tipo;
	}

	public void setTipo(TipoProjeto tipo) {
		this.tipo = tipo;
	}

	public double getValorNota() {
		return valorNota;
	}

	public void setValorNota(Float valorNota) {
		this.valorNota = valorNota;
	}


	public GrupoChallenge getGrupo() {
		return grupo;
	}


	public void setGrupo(GrupoChallenge grupo) {
		this.grupo = grupo;
	}
	
	
	
	
	
	
}
