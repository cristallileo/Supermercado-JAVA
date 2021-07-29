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

@WebServlet("/ListEmpleados")

public class ListEmpleados extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListEmpleados() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PersonaController ctrl= new PersonaController();
		LinkedList<Persona> empleados= new LinkedList<Persona>();
		Persona per= new Persona();
		per= (Persona)request.getSession(true).getAttribute("usuario");
		if(per==null){
			request.getRequestDispatcher("error-sesion.jsp").forward(request, response);
		}
		empleados=ctrl.listarEmpleados();
			
			request.setAttribute("desc", null);
			request.setAttribute("empleados", empleados);
	        request.getRequestDispatcher("listarEmpleados.jsp").forward(request, response);
		


	}

}
