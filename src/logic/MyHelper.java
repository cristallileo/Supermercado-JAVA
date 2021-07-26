package logic;

import java.sql.Date;
import java.util.LinkedList;

import entidades.*;

public class MyHelper {

	public MyHelper(){
		
	}
	
	public void verificarFechas (Date desde, Date hasta) throws CustomException{
		if (desde.after(hasta)) {
			throw new CustomException("La fecha de comienzo no puede ser posterior a la fecha de fin.");
		}
	}

	public void isClienteDuplicado(String email) throws CustomException {
		
		LinkedList<Persona> clientes = new LinkedList<Persona>();
		PersonaController ctrl= new PersonaController();
		
		clientes= ctrl.listarClientes();
		
		for (Persona c: clientes) {
			if (c.getEmail().equals(email)) {
				throw new CustomException("La cuenta de email "+ c.getEmail() + " ya se encuentra en uso.");
			}
			
		}
		
	}

	public void isEmpleadoDuplicado(String email) throws CustomException {
	
		LinkedList<Persona> empleados = new LinkedList<Persona>();
		PersonaController ctrl= new PersonaController();
		
		empleados= ctrl.listarEmpleados();
		
		for (Persona e: empleados) {
			if (e.getEmail().equals(email)) {
				throw new CustomException("La cuenta de email "+ e.getEmail() + " ya se encuentra en uso.");
			}
			
		}
		
	}
	
	
	public Boolean isNumeric(String cadena) {
		Boolean resultado;
		try {
			Integer.parseInt(cadena);
			resultado=true;
	
		} catch (NumberFormatException nfe){
			resultado=false;
			
		}
		return resultado;
	}

	}
	
	

