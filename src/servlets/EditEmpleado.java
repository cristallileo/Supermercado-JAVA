package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Persona;
import logic.MyHelper;
import logic.PersonaController;

/**
 * Servlet implementation class EditEmpleado
 */
@WebServlet("/EditEmpleado")
public class EditEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmpleado() {
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
		
		MyHelper h= new MyHelper();
		Persona per= new Persona();
		
		PersonaController ctrl= new PersonaController();
		
		String nombre= request.getParameter("name");
		String apellido= request.getParameter("surname");
		String tDoc= request.getParameter("tipoDoc");
		String nDoc= request.getParameter("nroDoc");
		String telefono= request.getParameter("tel");
		String direccion= request.getParameter("direc");
		String pass= request.getParameter("pass");

		int id = Integer.parseInt(request.getParameter("id"));
		
		if(h.isNumeric(nDoc)==false) {
			request.getRequestDispatcher("error-doc.jsp").forward(request, response);
		}else if(h.isNumeric(telefono)==false) {
			request.getRequestDispatcher("error-tel.jsp").forward(request, response);
		} else {
		per.setIdPersona(id);
		per.setTipoDoc(tDoc);
		per.setNroDoc(nDoc);
		per.setNombre(nombre);
		per.setApellido(apellido);
		per.setTelefono(telefono);
		per.setDireccion(direccion);
		per.setPassword(pass);

		per=ctrl.editPersona(per);
		LinkedList<Persona> empleados= new LinkedList<Persona>();
		empleados=ctrl.listarEmpleados();
		
		request.setAttribute("desc", null);
		request.setAttribute("empleados", empleados);
	    request.getRequestDispatcher("listarEmpleados.jsp").forward(request, response);

		

	}
		
 }

}
