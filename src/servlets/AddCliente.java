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
import entidades.Persona;
import logic.CustomException;
import logic.MyHelper;
import logic.PersonaController;

@WebServlet("/AddClientes")

public class AddCliente extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    public AddCliente() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Persona per= new Persona();
		Persona cli= new Persona();
		PersonaController ctrl= new PersonaController();
		MyHelper h= new MyHelper();
		
		String nombre= request.getParameter("name");		
		String apellido= request.getParameter("surname");				
		String tDoc= request.getParameter("tipoDoc");		
		String nDoc= request.getParameter("nroDoc");		
		String telefono= request.getParameter("tel");	
		String direccion= request.getParameter("direc");	
		String email= request.getParameter("email");
		String pass= request.getParameter("pass");
		
		//cuenta de mail duplicada?
		LinkedList<Persona> clientes = new LinkedList<Persona>();
		clientes= ctrl.listarClientes();
		for (Persona c: clientes) {
			if (c.getEmail().equals(email)) {
				request.setAttribute("message_cliente1","La cuenta de email "+ c.getEmail() + " ya se encuentra en uso.");
				request.getRequestDispatcher("registro.jsp").forward(request, response);
			
		}}
		//doc es numerico?
			if(h.isNumeric(nDoc)==false) {
				request.setAttribute("message_cliente2","El campo número de documento debe ser numérico.");
				request.getRequestDispatcher("registro.jsp").forward(request, response);
			}else
			
			
		if(h.isNumeric(telefono)==false) {
			request.setAttribute("message_cliente3","El campo teléfono debe ser numérico. No incluir guiones.");
			request.getRequestDispatcher("registro.jsp").forward(request, response);
		}else {
		
		per.setTipoDoc(tDoc);
		per.setNroDoc(nDoc);
		per.setNombre(nombre);
		per.setApellido(apellido);
		per.setTelefono(telefono);
		per.setDireccion(direccion);
		per.setEmail(email);
		per.setPassword(pass);
		per.setCuil("");
		per.setFechaIngreso(null);
		per.setFecha_hora_baja(null);

		java.sql.Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());
		per.setFechaRegistro(timeNow);
 
		cli=ctrl.addPersona(per);
		
		request.setAttribute("nuevoCliente", cli);
		request.getRequestDispatcher("registro-aceptado.jsp").forward(request, response);
					
		}}
		
	}


