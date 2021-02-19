package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Data.*;
import entidades.*;
import logic.CategoriaController;


/**
 * Servlet implementation class ListClientes
 */
@WebServlet("/ListCategorias")
public class ListCategorias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCategorias() {
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
		//doGet(request, response);
		
		CategoriaController ctrl= new CategoriaController();
		LinkedList<Categoria> categorias= new LinkedList<Categoria>();
		categorias=ctrl.listarCategorias();
		request.setAttribute("categorias", categorias);
        request.getRequestDispatcher("listarCategorias.jsp").forward(request, response);

        
	}

}