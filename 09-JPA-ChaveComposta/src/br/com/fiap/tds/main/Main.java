package br.com.fiap.tds.main;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.ItemPedidoDao;
import br.com.fiap.tds.dao.impl.ItemPedidoDaoImpl;
import br.com.fiap.tds.entity.ItemPedido;
import br.com.fiap.tds.entity.ItemPedidoPK;
import br.com.fiap.tds.entity.Pedido;
import br.com.fiap.tds.entity.Produto;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Main {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		ItemPedidoDao itemDao = new ItemPedidoDaoImpl(em);
		
		Produto produto = new Produto("suco");
		
		Pedido pedido = new Pedido(Calendar.getInstance(), 1510.0);
		
		ItemPedido item = new ItemPedido(produto, pedido, 5.0, 2);
		
		try {
			itemDao.create(item);
			itemDao.commit();
			System.out.println("foi");
		} catch (CommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			//Pesquisar um item de pedido pela PK
			ItemPedidoPK pk = new ItemPedidoPK(1, 1, 1);
			ItemPedido itemPedido = itemDao.search(pk);
			System.out.println(itemPedido.getProduto().getNome() + " " + itemPedido.getValor());
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}
	
}
