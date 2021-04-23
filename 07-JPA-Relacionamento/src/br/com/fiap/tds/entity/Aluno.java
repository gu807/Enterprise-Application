package br.com.fiap.tds.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_ALUNO")
@SequenceGenerator(name = "aluno", allocationSize = 1, sequenceName = "SQ_TB_ALUNO")
public class Aluno {

	@Id
	@Column(name = "cd_aluno")
	@GeneratedValue(generator = "aluno", strategy = GenerationType.SEQUENCE)
	private int cd;
	
	@Column(name = "nm_aluno", nullable = false, length = 100)
	private String name;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_nascimento")
	private Calendar birthDate;
	
	@Column(name = "ds_papel", length = 40)
	private String papel;
	
	@ManyToOne
	@JoinColumn(name = "cd_grupo", nullable = false)
	private GrupoChallenge grupo;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	//JoinTable -> configura a tabela associativa
	//name -> Nome da tabela associativa
	//joinColums -> configura a pk/fk da classe que estamos
	//inverseJoinColumns -> configura a coluna da fk/pk da classe do outro lado da relação
	@JoinTable(name = "TB_ALUNO_NANO_COURSE", joinColumns = @JoinColumn(name="cd_aluno"),
												inverseJoinColumns = @JoinColumn(name="cd_curso"))
	private List<NanoCourse> cursos;

	public Aluno() {
	}
	

	public Aluno(int cd, String name, Calendar birthDate, String papel) {
		this.cd = cd;
		this.name = name;
		this.birthDate = birthDate;
		this.papel = papel;
	}

	public Aluno(String name, Calendar birthDate, String papel) {
		this.name = name;
		this.birthDate = birthDate;
		this.papel = papel;
	}

	public int getRm() {
		return cd;
	}

	public void setRm(int rm) {
		this.cd = rm;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

	public GrupoChallenge getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoChallenge grupo) {
		this.grupo = grupo;
	}

	public List<NanoCourse> getCursos() {
		return cursos;
	}
	
	public void setCursos(List<NanoCourse> cursos) {
		this.cursos = cursos;
	}
	@Override
	public String toString() {
		return "Aluno [rm=" + cd + ", name=" + name + ", birthDate=" + birthDate + ", papel=" + papel + ", grupo="
				+ grupo + "]";
	}
	
	
	
	
	
	
}
