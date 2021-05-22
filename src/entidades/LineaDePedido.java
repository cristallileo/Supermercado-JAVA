package entidades;

import java.sql.Date;

public class LineaDePedido {

	private int id_pedido,id_producto;
	private int cantidad;
	private Date fecha_hora_baja;
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public Date getFecha_hora_baja() {
		return fecha_hora_baja;
	}
	public void setFecha_hora_baja(Date fecha_hora_baja) {
		this.fecha_hora_baja = fecha_hora_baja;
	}
	
	
	
}