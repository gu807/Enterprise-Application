package br.com.fiap.tds.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "TB_GRUPO_CHALLENGE")
@SequenceGenerator(name = "grupo", allocationSize = 1, sequenceName = "SQ_TB_GRUPO_CHALLENGE")

public class GrupoChallenge {

	@Id
	@Column(name = "cd_grupo")
	@GeneratedValue(generator = "grupo", strategy = GenerationType.SEQUENCE)
	private int cd;
	
	@Column(name = "nm_grupo", nullable = false, length = 50)
	private String name;
	
	//Mapear o relacionamento 1 - 1
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cd_projeto", nullable = false)
	private ProjetoChallenge projeto;
	
	@OneToMany(mappedBy = "grupo", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<Aluno> alunos;
	
	public void addAluno(Aluno aluno) {
		if (alunos == null)
			alunos = new ArrayList<>();
		
		//Adicionar o aluno na lista
		
		alunos.add(aluno);
		
		//setar o grupo do aluno
		aluno.setGrupo(this);
		
	}
	
	public GrupoChallenge() {
	}
	
	public GrupoChallenge(String name, ProjetoChallenge projeto) {
		super();
		this.name = name;
		this.projeto = projeto;
	}
	
	public GrupoChallenge(int cd, String name, ProjetoChallenge projeto) {
		super();
		this.cd = cd;
		this.name = name;
		this.projeto = projeto;
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

	public ProjetoChallenge getProjeto() {
		return projeto;
	}

	public void setProjeto(ProjetoChallenge projeto) {
		this.projeto = projeto;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	
	
	
}
