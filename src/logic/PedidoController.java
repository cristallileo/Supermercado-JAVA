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

	//Calcula el valor del atributo precioTotal de los pedidos
	public Pedido editTotal (Pedido p) {
		return dp.editTotal(p);
	}
	public void deletePedido (Pedido p) {
		 dp.deletePedido(p);
	}
	
	public Pedido getById(Pedido p) {
		return dp.getById(p);
	}
	
	public void add(Pedido p) {
		 dp.add(p);
	}
	
	public void confirmarPedido(Pedido p) {
		dp.confirmarPedido(p);
	}

	public LinkedList<Pedido> getByCliente(Persona per) {
		//return dp.getByCliente(per);
		LinkedList<Pedido> pedidos1= new LinkedList<Pedido>();
		LinkedList<Pedido> pedidos2= new LinkedList<Pedido>();
		pedidos1= this.listarPedidos();
		for (Pedido p: pedidos1) {
			if(p.getId_persona()==per.getIdPersona()) {
				pedidos2.add(p);
			}
		}
		return pedidos2;
	}
}
