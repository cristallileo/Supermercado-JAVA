package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Categoria;
import logic.CategoriaController;

/**
 * Servlet implementation class ListCategoriasDesc
 */
@WebServlet("/ListCategoriasDesc")
public class ListCategoriasDesc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCategoriasDesc() {
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
		
		CategoriaController ctrl= new CategoriaController();
		LinkedList<Categoria> categorias= new LinkedList<Categoria>();

		String desc= request.getParameter("search");		
		categorias=ctrl.listarByDesc(desc);
		
		request.setAttribute("descrip", desc);
		request.setAttribute("categorias", categorias);
        request.getRequestDispatcher("listarCategorias.jsp").forward(request, response);
		
		
	}

}
