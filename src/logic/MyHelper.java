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
	
/*	public void isCatDuplicada (String desc_cat) throws CustomException{
		
		LinkedList<Categoria> cats= new LinkedList<Categoria>();
		CategoriaController ctrl= new CategoriaController();
		
		cats= ctrl.listAllCategorias();
		
		for (Categoria c: cats) {
			if (c.getDescCategoria().equals(desc_cat)) {
				throw new CustomException("La categoría "+ c.getDescCategoria()+" ya existe.");
			}
		}
		
	} */

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
	
	public  void docIsNumeric(String cadena) throws CustomException{
		try {
			Integer.parseInt(cadena);
	
		} catch (NumberFormatException nfe){
			throw new CustomException("El campo número de documento debe ser numérico.");
		}
	}
	
	public  void cuilIsNumeric(String cadena) throws CustomException{
		try {
			Integer.parseInt(cadena);
	
		} catch (NumberFormatException nfe){
			throw new CustomException("El campo CUIL debe ser numérico. No incluir guiones.");
		}
	}
	
	public  void telIsNumeric(String cadena) throws CustomException{
		try {
			Integer.parseInt(cadena);
	
		} catch (NumberFormatException nfe){
			throw new CustomException("El campo teléfono debe ser numérico.");
		}
	}
	}
	
	

