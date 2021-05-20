package br.com.fiap.tds.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_EAD_PRODUTO")
@SequenceGenerator(name = "produto", allocationSize = 1, sequenceName = "SQ_TB_EAD_PRODUTO")
public class Produto {

	@Id
	@Column(name = "cd_produto", nullable = false)
	@GeneratedValue(generator = "produto", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "nm_produto", nullable = false, length = 80)
	private String nome;
	
	@OneToMany(mappedBy = "produto")
	private List<ItemPedido> itens;

	public Produto() {
	}
	
	


	public Produto(String nome) {
		this.nome = nome;
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
	
	public List<ItemPedido> getItens() {
		return itens;
	}
	
	
	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}
	
	
	
}
