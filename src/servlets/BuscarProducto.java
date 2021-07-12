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
import entidades.Proveedor;
import logic.CategoriaController;
import logic.ProductoController;
import logic.ProveedorController;

/**
 * Servlet implementation class BuscarProducto
 */
@WebServlet("/BuscarProducto")
public class BuscarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		ProductoController ctrl= new ProductoController();
		Producto prod= new Producto();
		
		
		int id= Integer.parseInt(request.getParameter("id"));
		prod.setIdProducto(id);
		prod =ctrl.getById(prod);
	
		CategoriaController ctrlCat= new CategoriaController();
		Categoria cat= new Categoria();
		
		cat= ctrl.getCategoria(prod);
		
		
		request.setAttribute("cat",	cat);
		request.setAttribute("productoEditar", prod);
		request.setAttribute("categorias", ctrlCat.listAllCategorias() );
		request.getRequestDispatcher("editarProducto.jsp").forward(request, response);
				
		
	}

}

