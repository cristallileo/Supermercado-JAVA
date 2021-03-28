package logic;

import java.util.LinkedList;
import Data.*;
import entidades.*;

public class ProductoController {

	private DataProducto dp;

	public ProductoController() {
		dp=new DataProducto();
	}
	
	public LinkedList<Producto> listAllProductos() {
		return dp.getAll();
	}

	public Producto editProducto (Producto p) {
		return dp.editProducto(p);
	}
	
	public Producto deleteProducto (Producto p) {
		return dp.deleteProducto(p);
	}
	
	public Producto getById(Producto p) {
		Producto prod=new Producto();
		prod=dp.getById(p);
		return prod;
	}
	
	public void addProducto(Producto p) {
		 dp.add(p);
	}
	
	public LinkedList<Producto> listarByCategoria (Categoria cat){
		return dp.getByCategoria(cat);
	}
	
	public LinkedList<Producto> listarMenosMas (){
		return dp.getMenosMas();
	}
	
	public LinkedList<Producto> listarMasMenos (){
		return dp.getMasMenos();
	}
	
	public LinkedList<Producto> listarByDesc (String desc){
		return dp.getByDesc(desc);
	}
	
	public LinkedList<Producto> listProductosActivos() {
		return dp.getAllActivos();	
	}
	
	public Categoria getCategoria(Producto p) {
		int id= p.getId_categoria();
		Categoria c = new Categoria();
		c.setIdCategoria(id);
		CategoriaController ctrl = new CategoriaController();
		c=ctrl.getOne(c);
		return c;
	}
	
}
