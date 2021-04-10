package entidades;

import java.sql.Blob;
import java.sql.Timestamp;

public class Producto implements Comparable <Producto>{
	
	private int idProducto;
	private String descProducto;
	private int stock;
	private int stockMinimo;
	private String marca;
	private int id_categoria;
	private Double precio;
	private Timestamp fecha_hora_baja; 
	private Blob imagen;

	
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	
	public String getDescProducto() {
		return descProducto;
	}
	public void setDescProducto(String descProducto) {
		this.descProducto = descProducto;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getStockMinimo() {
		return stockMinimo;
	}
	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	public Timestamp getFecha_hora_baja() {
		return fecha_hora_baja;
	}
	
	public void setFecha_hora_baja(Timestamp fecha_hora_baja)
	{
		this.fecha_hora_baja = fecha_hora_baja;
	}
	
	public Blob getImagen() {
		return imagen;
	}
	public void setImagen(Blob imagen) {
		this.imagen = imagen;
	}
	
	@Override
	public int compareTo(Producto p) {
		return precio.compareTo(p.getPrecio());	
	}
	
}