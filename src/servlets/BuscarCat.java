package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Categoria;
import entidades.Persona;
import entidades.Producto;
import logic.CategoriaController;
import logic.ProductoController;

@WebServlet("/BuscarCat")

public class BuscarCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BuscarCat() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	//	doGet(request, response);
		LinkedList<Producto> prods = new LinkedList<Producto>();
		LinkedList<Categoria> categorias = new LinkedList<Categoria>();
		CategoriaController ctrl= new CategoriaController();
		Categoria cat= new Categoria();
		ProductoController ctrlProd= new ProductoController();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		cat.setIdCategoria(id);
		cat =ctrl.getOne(cat);		
		prods= ctrlProd.listarByCategoria(cat);
		
		//Veo a donde lo direcciono:
  		Persona per= new Persona();
  		per= (Persona)request.getSession(true).getAttribute("usuario");
  		
  		// si es cliente solo me traigo las categorias y los productos activos
  		
  		if(per.isCliente()==true) {
  			categorias= ctrl.listCategoriasActivas();
			categorias=ctrl.listCategoriasNoVacias(categorias);
  			request.setAttribute("categorias", categorias);
  			LinkedList<Producto> prods_activos= new LinkedList<Producto>();
  			for (Producto p: prods) {
  				if (p.getFecha_hora_baja()==null) {
  					prods_activos.add(p);
  				}
  			}
  			 request.setAttribute("productos", prods_activos);
  			 request.getRequestDispatcher("productos.jsp").forward(request, response);
  			 
  			 //si es empleado traigo activos y no activos
  			
  		}else {
  			categorias= ctrl.listAllCategorias();
  			request.setAttribute("categorias", categorias);
  			request.setAttribute("productos", prods);
  			request.getRequestDispatcher("listarProductos.jsp").forward(request, response);
  		}
	}

}
