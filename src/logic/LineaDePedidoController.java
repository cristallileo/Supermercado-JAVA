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
		LinkedList<LineaDePedido> lineas= new  LinkedList<LineaDePedido>();
		LinkedList<LineaDePedido> lineas2= new  LinkedList<LineaDePedido>();
		lineas= dl.getByPedido(ped);
		for (LineaDePedido linea: lineas) {
			if(linea.getFecha_hora_baja()==null && linea.getCantidad()!=0) {
				lineas2.add(linea);
			}
		}
		return lineas2;
	}

	public LineaDePedido darDeBaja (LineaDePedido linea) {
		return dl.darDeBaja(linea);
	}

}
