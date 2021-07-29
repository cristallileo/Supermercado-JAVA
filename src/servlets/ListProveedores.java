package servlets;

import java.io.IOException;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.*;
import logic.*;

@WebServlet("/ListProveedores")

public class ListProveedores extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public ListProveedores() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProveedorController ctrl= new ProveedorController();
		LinkedList<Proveedor> proveedores= new LinkedList<Proveedor>();
		Persona per= new Persona();
		per= (Persona)request.getSession(true).getAttribute("usuario");
		if(per==null){
			request.getRequestDispatcher("error-sesion.jsp").forward(request, response);
		}
		proveedores=ctrl.listarProveedores();
		
			request.setAttribute("descrip", null);
			request.setAttribute("proveedores", proveedores);
	        request.getRequestDispatcher("listarProveedores.jsp").forward(request, response);
			
	}
}
