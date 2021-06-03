package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Persona;
import logic.PersonaController;

/**
 * Servlet implementation class DeleteEmpleado
 */
@WebServlet("/DeleteEmpleado")
public class DeleteEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEmpleado() {
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
		Persona per= new Persona();
		
		
		//Persona cli = (Persona)request.getSession().getAttribute("cliente_eliminar");
		//Persona eliminada= ctrl.deletePersona(cli);
	
		int id = Integer.parseInt(request.getParameter("id"));
		//response.getWriter().append("Served at: ").append(id);
		per.setIdPersona(id);
		per =ctrl.getById(per);
		per=ctrl.deleteEmpleado(per);
		request.setAttribute("empleados", ctrl.listarEmpleados());
		request.getRequestDispatcher("ListEmpleados").forward(request, response);
	
	}

}
