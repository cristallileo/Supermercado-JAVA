package logic;

import java.util.LinkedList;
import Data.*;
import entidades.*;

@SuppressWarnings("unused")

public class CategoriaController {
	
	private DataPersona dp;
	private DataProducto dprod;
	private DataCategoria dc;
	
	public CategoriaController() {
		dc=new DataCategoria();
	}
	public LinkedList<Categoria> listAllCategorias() {
		return dc.getAll();
	}
	public Categoria editCategoria (Categoria c) {
		return dc.editCategoria(c);
	}
	public Categoria deleteCategoria (Categoria c) {
		return dc.deleteCategoria(c);
	}
	
	public Categoria getOne(Categoria cat) {
		Categoria c = new Categoria();
		c = dc.getOne(cat);
		return c;
	}
	
	public void addCategoria(Categoria cat) {
		dc.addCategoria(cat);
	}
	
	public LinkedList<Categoria> listCategoriasActivas() {
		return dc.getAllActivas();
	}
	
	public Categoria getOneByDesc(Categoria cat) {
		Categoria c = new Categoria();
		c = dc.getOneByDesc(cat);
		return c;
	}
	
	public LinkedList<Categoria> listarByDesc (String categ){
		return dc.getByDesc(categ);
	}
	
	//Toma las categorias activas y se fija cuales tienen al menos un producto cargado. No tiene sentido mostrarle la cat al cliente si viene vacia.
	public LinkedList<Categoria> listCategoriasNoVacias(LinkedList<Categoria> cats){
		LinkedList<Categoria> categorias= new LinkedList<Categoria>();
		for (Categoria c: cats) {
			LinkedList<Producto> prods= new LinkedList<Producto>();
			ProductoController ctrl= new ProductoController();
			prods= ctrl.listarByCategoria(c);
			if(prods.size()>=1) {
				categorias.add(c);
			}
		}
		return categorias;
	}
	
}