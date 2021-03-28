package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Categoria;
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
		CategoriaController ctrl= new CategoriaController();
		Categoria cat= new Categoria();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		cat.setIdCategoria(id);
		cat =ctrl.getOne(cat);
		
		LinkedList<Categoria> categorias = new LinkedList<Categoria>();
		categorias= ctrl.listAllCategorias();
		
		ProductoController ctrlProd= new ProductoController();
		
		LinkedList<Producto> prods = new LinkedList<Producto>();
		prods= ctrlProd.listarByCategoria(cat);
		
		request.setAttribute("categorias", categorias);

		request.setAttribute("productos", prods);
		request.getRequestDispatcher("listarProductos.jsp").forward(request, response);
	}

}
