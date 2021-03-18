package servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import entidades.*;
import logic.PersonaController;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddEmpleado")

public class AddEmpleado extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public AddEmpleado() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

		java.sql.Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());
		
		per.setFechaIngreso(timeNow);

		emp=ctrl.addEmpleado(per);

		request.setAttribute("nuevoEmpleado", emp);
		request.setAttribute("empleados", ctrl.listarEmpleados());
		request.getRequestDispatcher("ListEmpleados").forward(request, response);
					
	}

}
