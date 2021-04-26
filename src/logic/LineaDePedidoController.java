package logic;

import java.util.LinkedList;

import Data.*;
import entidades.*;

public class LineaDePedidoController {
	
	private DataLineaDePedido dl;
	
	public LineaDePedidoController() {
		dl=new DataLineaDePedido();
	}

	public void addLinea(LineaDePedido lp) {
		dl.add(lp);
	}
	
	public LinkedList<LineaDePedido> getByPedido (Pedido ped) {
		return dl.getByPedido(ped);
	}


}
