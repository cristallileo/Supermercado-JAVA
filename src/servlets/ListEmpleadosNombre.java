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
 * Servlet implementation class ListEmpleadosRazon
 */
@WebServlet("/ListEmpleadosNombre")
public class ListEmpleadosNombre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListEmpleadosNombre() {
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
		PersonaController ctrl= new PersonaController();
		LinkedList<Persona> empleados= new LinkedList<Persona>();
		
		String desc= request.getParameter("search");
		empleados=ctrl.listarEmpleadosNombre(desc);
		
		//request.getAttribute("usuario");
		request.setAttribute("descrip", desc);
		request.setAttribute("empleados", empleados);
        request.getRequestDispatcher("listarEmpleados.jsp").forward(request, response);
	}

}
