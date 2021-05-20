package br.com.fiap.tds.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_EAD_PEDIDO")
@SequenceGenerator(name = "pedido", allocationSize = 1, sequenceName = "SQ_TB_EAD_PEDIDO")
public class Pedido {

	@Id
	@Column(name = "cd_pedido", nullable = false)
	@GeneratedValue(generator = "pedido", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_pedido", nullable = false)
	private Calendar data;
	
	@Column(name = "vl_pedido", nullable = false)
	private Double valor;
	
	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> itens;


	public Pedido() {
	}
	
	public Pedido(int codigo, Calendar data, Double valor) {
		this.codigo = codigo;
		this.data = data;
		this.valor = valor;
	}
	
	
	public Pedido(Calendar data, Double valor) {
		this.data = data;
		this.valor = valor;
	}

	public Pedido(Double valor) {
		this.valor = valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public List<ItemPedido> getItens() {
		return itens;
	}
	
	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}
	
	
	
	
	
}
