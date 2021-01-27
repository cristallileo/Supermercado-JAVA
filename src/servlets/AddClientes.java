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
 * Servlet implementation class AddClientes
 */
@WebServlet("/AddClientes")
public class AddClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClientes() {
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
		Persona per= new Persona();
		PersonaController ctrl= new PersonaController();
		
		String nombre= request.getParameter("name");
		per.setNombre(nombre);
		String apellido= request.getParameter("surname");
		per.setApellido(apellido);
		
		per.setCliente(true);
		
		String tDoc= request.getParameter("tipoDoc");
		per.setTipoDoc(tDoc);
		String nDoc= request.getParameter("nroDoc");
		per.setNroDoc(nDoc);

		String telefono= request.getParameter("tel");
		per.setTelefono(telefono);
		String direccion= request.getParameter("direc");
		per.setDireccion(direccion);
		String email= request.getParameter("email");
		per.setEmail(email);
		String pass= request.getParameter("psw");
		per.setPassword(pass);
		//String pass2= request.getParameter("psw-repeat");
		//per.setPassword(pass2);
		
		//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		  // LocalDateTime now = LocalDateTime.now(); 
		per=ctrl.addPersona(per);
			
			request.setAttribute("nuevoCliente", per);
			request.getRequestDispatcher("registro-aceptado.jsp").forward(request, response);
			
			
			
		}
	
		
			
			//cartel de q esta mal
		
	}


