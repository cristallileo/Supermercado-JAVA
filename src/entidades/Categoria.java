package entidades;

import java.sql.Timestamp;

public class Categoria {

	private int idCategoria;
	private String descCategoria;
	private Timestamp fecha_hora_baja;
	
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getDescCategoria() {
		return descCategoria;
	}
	public void setDescCategoria(String descCategoria) {
		this.descCategoria = descCategoria;
	}
	
	public Timestamp getFecha_hora_baja() {
		return fecha_hora_baja;
	}
	
	public void setFecha_hora_baja(Timestamp fecha_hora_baja)
	{
		this.fecha_hora_baja = fecha_hora_baja;
	}
		
}