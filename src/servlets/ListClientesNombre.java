package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Persona;
import logic.PersonaController;

/**
 * Servlet implementation class ListClientesNombre
 */
@WebServlet("/ListClientesNombre")
public class ListClientesNombre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListClientesNombre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PersonaController ctrl= new PersonaController();
		LinkedList<Persona> clientes= new LinkedList<Persona>();
		
		String desc= request.getParameter("search2");
		clientes=ctrl.listarClientesNombre(desc);
		if(clientes.size()>=1) {
		
		request.setAttribute("descrip", desc);
		request.setAttribute("listado", clientes);
        request.getRequestDispatcher("listarClientes.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("error-gral.jsp").forward(request, response);
		}	
	}
}
