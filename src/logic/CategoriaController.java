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
	public LinkedList<Categoria> listarCategorias() {
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
	
	
}