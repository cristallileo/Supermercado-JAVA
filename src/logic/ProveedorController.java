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
	
	public Proveedor getById(Proveedor p) {
		Proveedor prov=new Proveedor();
		prov=dp.getById(p);
		return prov;
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
	
}
