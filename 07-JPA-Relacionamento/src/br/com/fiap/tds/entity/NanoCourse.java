package br.com.fiap.tds.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_NANO_COURSE")
@SequenceGenerator(name = "nano", allocationSize = 1, sequenceName = "SQ_TB_NANO_COURSE")
public class NanoCourse {

	@Id
	@Column(name = "cd_curso")
	@GeneratedValue(generator = "nano", strategy = GenerationType.SEQUENCE)
	private int cd;
	
	@Column(name = "nm_curso", nullable = false , length = 90)
	private String name;
	
	@Column(name = "nr_creditos", nullable = false)
	private Integer creditos;
	
	@Column(name = "nr_carga_horaria", nullable = false)
	private Integer cargaHoraria;
	
	@Column(name = "ds_categoria", length = 40, nullable = false)
	private String categoria;

	//Mapear o relacionamento muito para muitos bidirecional
	@ManyToMany(mappedBy = "cursos", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<Aluno> alunos;
	
	
	public NanoCourse() {
	}
	
	public NanoCourse(String name, Integer creditos, Integer cargaHoraria, String categoria) {
		this.name = name;
		this.creditos = creditos;
		this.cargaHoraria = cargaHoraria;
		this.categoria = categoria;
	}

	public NanoCourse(int cd, String name, Integer creditos, Integer cargaHoraria, String categoria) {
		this.cd = cd;
		this.name = name;
		this.creditos = creditos;
		this.cargaHoraria = cargaHoraria;
		this.categoria = categoria;
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

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	
}
