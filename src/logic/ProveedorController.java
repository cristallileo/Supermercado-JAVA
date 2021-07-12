package logic;
import java.util.LinkedList;
import Data.*;
import entidades.*;

public class ProveedorController {

	private DataProveedor dp;

		
	public ProveedorController() {
			dp=new DataProveedor();
	}

	public LinkedList<Proveedor> listarProveedores() {
			return dp.getAll();
	}
	
	public  LinkedList<Proveedor> listarActivos() {
		LinkedList<Proveedor> p= new LinkedList<Proveedor>();
		LinkedList<Proveedor> p1= new LinkedList<Proveedor>();
		p= this.listarProveedores();
		for (Proveedor prov: p) {
			if(prov.getFechaBaja()==null) {
				p1.add(prov);
			}
		}
		return p1;
	}
	
	public Proveedor getById(Proveedor p) {
		
		return dp.getById(p);
	}
	
	public Proveedor add(Proveedor p) {
		return dp.add(p);	
	}	
	
	public void deleteProveedor(Proveedor p) {
		 dp.deleteProveedor(p);
	}
	
	public Proveedor editProveedor (Proveedor p) {
		return dp.editProveedor(p);
	}

	public LinkedList<Proveedor> listarByDesc (String razonS){
		return dp.getByDesc(razonS);
	}
	
	
}

