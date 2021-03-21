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
	
	public void isCatDuplicada (String desc_cat) throws CustomException{
		
		LinkedList<Categoria> cats= new LinkedList<Categoria>();
		CategoriaController ctrl= new CategoriaController();
		
		cats= ctrl.listarCategorias();
		
		for (Categoria c: cats) {
			if (c.getDescCategoria().equals(desc_cat)) {
				throw new CustomException("La categoría "+ c.getDescCategoria()+" ya existe.");
			}
		}
		
	}
	
	
}
