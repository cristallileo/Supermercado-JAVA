  
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
	public Persona deletePersona (Persona p) {
		return dp.deletePersona(p);
	}
	
	public Persona getById(Persona per) {
		Persona p=new Persona();
		p= dp.getById(per);
		return p;
	}
	
	public Persona addPersona(Persona per) {
		 return dp.add(per);
	}


	public Persona addEmpleado(Persona per) {
		
		return dp.addEmpleado(per);
	}
	
	 

}