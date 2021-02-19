package servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Categoria;
import entidades.Persona;
import logic.CategoriaController;
import logic.PersonaController;

/**
 * Servlet implementation class AddClientes
 */
@WebServlet("/AddCategoria")
public class AddCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCategoria() {
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
		
		//response.getWriter().append("Hola: ").append(nombre);		
		
		Categoria cat= new Categoria();
		CategoriaController ctrl= new CategoriaController();
		
		String desc_categoria = request.getParameter("descrip");
				
		cat.setDescCategoria(desc_categoria);
		ctrl.addCategoria(cat);
		request.setAttribute("nuevaCategoria", cat);
		request.setAttribute("categorias", cat);
		request.getRequestDispatcher("ListCategorias").forward(request, response);
			
			
			
		}
	
			//cartel de q esta mal
		
	}


