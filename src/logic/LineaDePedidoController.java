package logic;

import java.util.LinkedList;

import Data.*;
import entidades.*;

public class LineaDePedidoController {
	
	private DataLineaDePedido dl;
	
	public LineaDePedidoController() {
		dl=new DataLineaDePedido();
	}

	public boolean addLinea(LineaDePedido lp) {
		PedidoController ctrl= new PedidoController();
		LinkedList<LineaDePedido> lineas= new LinkedList<LineaDePedido>();
		Pedido p = new Pedido();
		p.setIdPedido(lp.getId_pedido());
		p=ctrl.getById(p);
		lineas= this.getByPedido(p);
		boolean band=false;
		for(LineaDePedido li: lineas) {
			if(li.getId_producto()==lp.getId_producto() && band==false) {
				band=true;
			}
		}
		if(band==false) {
			dl.add(lp);
		}
		return band;
	}
	
	public LinkedList<LineaDePedido> getByPedido (Pedido ped) {
		return dl.getByPedido(ped);
	}

	public LineaDePedido deleteLineaDePedido (LineaDePedido linea) {
		return dl.deleteLineaDePedido(linea);
	}

}
