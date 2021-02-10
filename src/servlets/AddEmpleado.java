package servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

import Data.*;
import entidades.*;
import logic.PersonaController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddEmpleado
 */
@WebServlet("/AddEmpleado")
public class AddEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmpleado() {
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
		Persona per= new Persona();
		Persona emp= new Persona();
		PersonaController ctrl= new PersonaController();
		
		String nombre= request.getParameter("name");
		
		String apellido= request.getParameter("surname");
				
		String tDoc= request.getParameter("tipoDoc");
		
		String nDoc= request.getParameter("nroDoc");
		

		String telefono= request.getParameter("tel");
		
		String direccion= request.getParameter("direc");
		
		String cuil= request.getParameter("cuil");
		
		String email= request.getParameter("email");

		String pass= request.getParameter("pass");

		
		per.setTipoDoc(tDoc);
		per.setNroDoc(nDoc);
		per.setNombre(nombre);
		per.setApellido(apellido);
		per.setTelefono(telefono);
		per.setDireccion(direccion);
		per.setEmail(email);
		per.setPassword(pass);
		per.setCuil(cuil);
		per.setFechaRegistro(null);
		//per.setCliente(true);
		//per.setEmpleado(false);
		Date hoy = new Date(System.currentTimeMillis()); 
		java.sql.Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());
		//Date hoy= new Date(System.currentTimeMillis());
		per.setFechaIngreso(timeNow);

		emp=ctrl.addEmpleado(per);
		//LinkedList<Persona> personas = new LinkedList<Persona>();
		//personas=ctrl.listarClientes();
		
		request.setAttribute("nuevoEmpleado", emp);
		request.setAttribute("empleados", ctrl.listarEmpleados());
		request.getRequestDispatcher("ListEmpleados").forward(request, response);
			
		
	}

}
