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
import logic.PersonaController;

/**
 * Servlet implementation class ListClientes
 */
@SuppressWarnings("unused")
@WebServlet("/ListClientes")
public class ListClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListClientes() {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PersonaController ctrl= new PersonaController();
		LinkedList<Persona> clientes= new LinkedList<Persona>();
		Persona per= new Persona();
		per= (Persona)request.getSession(true).getAttribute("usuario");
		if(per==null){
			request.getRequestDispatcher("error-sesion.jsp").forward(request, response);
		}
		clientes=ctrl.listarClientes();
		if(clientes.size()>=1) {
			request.setAttribute("listado", clientes);
			request.setAttribute("descrip", null);
	        request.getRequestDispatcher("listarClientes.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("error-gral.jsp").forward(request, response);
		}
		        
	}

}
