package entidades;

import java.sql.Timestamp;
import java.sql.Date;

public class Descuento {

	private int idDcto;
	private Date fechaDctoFin, fechaDctoInicio;
	private Timestamp fecha_hora_baja;
	private Double porcDcto;
	
	public int getIdDcto() {
		return idDcto;
	}
	public void setIdDcto(int idDcto) {
		this.idDcto = idDcto;
	}
	public Date getFechaDctoFin() {
		return fechaDctoFin;
	}
	public void setFechaDctoFin(Date fechaDctoFin) {
		this.fechaDctoFin = fechaDctoFin;
	}
	public Date getFechaDctoInicio() {
		return fechaDctoInicio;
	}
	public void setFechaDctoInicio(Date fechDctoInicio) {
		this.fechaDctoInicio = fechDctoInicio;
	}
	public Double getPorcDcto() {
		return porcDcto;
	}
	public void setPorcDcto(Double porcDcto) {
		this.porcDcto = porcDcto;
	}
	public Timestamp getFecha_hora_baja() {
		return fecha_hora_baja;
	}
	public void setFecha_hora_baja(Timestamp fecha_hora_baja) {
		this.fecha_hora_baja = fecha_hora_baja;
	}

	
}
