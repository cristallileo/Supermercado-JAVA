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
	
	//Para la edicion del producto desde el admin
	public Producto editProducto (Producto p, Boolean isthereafile) {
		return dp.editProducto(p,isthereafile);
	}
	
	//Para los cambios que se van haciendo del producto (habilitación/deshabilitación/etc) que no son hechos por el admin
	public Producto actualizarProducto (Producto p) {
		return dp.actualizarProducto(p);
	}
	
	public Producto getById(Producto p) {
		return dp.getById(p);
	}
	
	public void addProducto(Producto p) {
		 dp.add(p);
	}
	
	public LinkedList<Producto> listarByCategoria (Categoria cat){
		return dp.getByCategoria(cat);
	}
	
	public LinkedList<Producto> listarByCategoriaAct (Categoria cat){
		return dp.getByCategoriaActivas(cat);
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
	
	public LinkedList<Producto> listarBajoStock(){
		LinkedList<Producto> prods = new LinkedList<Producto>();
		LinkedList<Producto> bajo_stock = new LinkedList<Producto>();
		prods= this.listAllProductos();
		for (Producto p: prods) {
			if (p.getStock()<=p.getStockMinimo()) {
				bajo_stock.add(p);
			}
		}
		return bajo_stock;
	}
	
	public int contarBajoStock() {
		LinkedList<Producto> prods = new LinkedList<Producto>();
		prods=this.listarBajoStock();
		return prods.size();
	}
}
