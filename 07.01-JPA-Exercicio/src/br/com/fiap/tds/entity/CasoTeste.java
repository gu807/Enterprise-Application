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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_CASO_TESTE")
@SequenceGenerator(name = "casoTeste", allocationSize = 1, sequenceName = "SQ_TAB_CASO_TESTE")
public class CasoTeste {
	
	@Id
	@Column(name = "cod_caso_teste")
	@GeneratedValue(generator = "casoTeste", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "nom_caso_teste")
	private String nome;
	
	@Column(name = "des_caso_teste")
	private String descricao;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cod_sistema", nullable = false)
	private Sistema sistema;
	
	@OneToMany(mappedBy = "caso", cascade = CascadeType.PERSIST)
	private List<ItemTeste> itens;
	
	public void addItem(ItemTeste item) {
		if (itens == null) 
			itens = new ArrayList<>();
		
		itens.add(item);
		
		item.setCaso(this);
		
		
		
	}
	

	public CasoTeste() {
	}
	
	public CasoTeste(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public CasoTeste(String nome, String descricao, Sistema sistema) {
		this.nome = nome;
		this.descricao = descricao;
		this.sistema = sistema;
	}

	public CasoTeste(int codigo, String nome, String descricao, Sistema sistema) {
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.sistema = sistema;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}
	
	public List<ItemTeste> getItens() {
		return itens;
	}
	
	public void setItens(List<ItemTeste> itens) {
		this.itens = itens;
	}
	
	

}
