package logic;

import java.util.LinkedList;

import Data.*;

import entidades.*;

public class PedidoController {

	
	private DataPedido dp;

	
	public PedidoController() {
		dp=new DataPedido();
	}

	
	public LinkedList<Pedido> listarPedidos() {
		return dp.getAll();
	}

	public Pedido editPedido (Pedido p) {
		return dp.editPedido(p);
	}
	public void deletePedido (Pedido p) {
		 dp.deletePedido(p);
	}
	
	public Pedido getById(Pedido p) {
		Pedido ped=new Pedido();
		ped=dp.getById(p);
		return ped;
	}
	
	public void add(Pedido p) {
		 dp.add(p);
	}
	
	public void confirmarPedido(Pedido p) {
		dp.confirmarPedido(p);
	}
}
