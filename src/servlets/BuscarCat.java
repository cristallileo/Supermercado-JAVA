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

/**
 * Servlet implementation class BuscarCat
 */
@WebServlet("/BuscarCat")
public class BuscarCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarCat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		CategoriaController ctrl= new CategoriaController();
		Categoria cat= new Categoria();
		int id = Integer.parseInt(request.getParameter("id"));
		cat.setIdCategoria(id);
		cat =ctrl.getOne(cat);
		LinkedList<Categoria> categorias = new LinkedList<Categoria>();
		categorias= ctrl.listarCategorias();
		
		ProductoController ctrlProd= new ProductoController();
		LinkedList<Producto> prods = new LinkedList<Producto>();
		
		prods= ctrlProd.listarByCategoria(cat);
		request.setAttribute("categorias", categorias);

		request.setAttribute("prods", prods);
		request.getRequestDispatcher("listarProductosCat.jsp").forward(request, response);
	}

}
