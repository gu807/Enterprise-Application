package br.com.fiap.tds.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_ITEM_TESTE")
@SequenceGenerator(name = "itemTeste", allocationSize = 1, sequenceName = "SQ_TAB_ITEM_TESTE")
public class ItemTeste {
	
	@Id
	@Column(name = "cod_item_teste")
	@GeneratedValue(generator = "itemTeste", strategy = GenerationType.SEQUENCE )
	private int codigo;
	

	@Column(name = "des_item_teste")
	private String descricao;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cod_caso_teste", nullable = false)
	private CasoTeste caso;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "TAB_ITEM_TESTE_USUARIO", joinColumns = @JoinColumn(name="cod_item_teste"), inverseJoinColumns = @JoinColumn(name="cod_usuario"))
	private List<Usuario> usuarios;

	public ItemTeste() {
	}
	
	public ItemTeste(String descricao) {
		this.descricao = descricao;
	}

	public ItemTeste(String descricao, CasoTeste caso) {
		this.descricao = descricao;
		this.caso = caso;
	}

	public ItemTeste(int codigo, String descricao, CasoTeste caso) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.caso = caso;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public CasoTeste getCaso() {
		return caso;
	}

	public void setCaso(CasoTeste caso) {
		this.caso = caso;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
	
	
}
