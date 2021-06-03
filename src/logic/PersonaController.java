  
package logic;

import java.util.LinkedList;

import Data.*;
import entidades.*;

@SuppressWarnings("unused")
public class PersonaController {
	
	private DataPersona dp;
	private DataProducto dprod;
	private DataCategoria dc;
	
	public PersonaController() {
		dp=new DataPersona();
	}

	
	public LinkedList<Persona> listarPersonas() {
		return dp.getAll();
	}
	
	public LinkedList<Persona> listarClientes() {
		return dp.getAllClientes();
	}
	
	public LinkedList<Persona> listarEmpleados(){
		return dp.getAllEmpleados();
	}
	
	public LinkedList<Persona> listarEmpleadosNombre(String nombre){
		LinkedList<Persona> personas= new LinkedList<Persona>();
		LinkedList<Persona> emps= new LinkedList<Persona>();
		personas= dp.getPersonaNombre(nombre);
		for (Persona p: personas) {
			if(p.isEmpleado()==true) {
				emps.add(p);
			}
		}
		return emps;
	}
	
	public LinkedList<Persona> listarClientesNombre(String nombre){
		LinkedList<Persona> personas= new LinkedList<Persona>();
		LinkedList<Persona> clientes= new LinkedList<Persona>();
		personas= dp.getPersonaNombre(nombre);
		for (Persona p: personas) {
			if(p.isCliente()==true) {
				clientes.add(p);
			}
		}
		return clientes;
	}
	
	public Persona editPersona (Persona p) {
		return dp.editPersona(p);
	}

	public Persona deshabilitarCliente (Persona p ) {
		return dp.deshabilitarCliente(p);
	}
	
	public Persona getById(Persona per) {
		return dp.getById(per);
	}
	
	public Persona addPersona(Persona per) {
		 return dp.add(per);
	}

	public Persona addEmpleado(Persona per) {	
		return dp.addEmpleado(per);
	}


	public Persona deleteEmpleado(Persona per) {
		return dp.deleteEmpleado(per);
	}


	public Persona habilitarCliente(Persona p) {
		return dp.habilitarCliente(p);
	}
	
	 

}