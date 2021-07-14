package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Persona;
import entidades.Proveedor;
import logic.ProveedorController;

/**
 * Servlet implementation class ContactarProveedor
 */
@WebServlet("/ContactarProveedor")
public class ContactarProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactarProveedor() {
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
		
		ProveedorController ctrl= new ProveedorController();
		LinkedList<Proveedor> proveedores= new LinkedList<Proveedor>();
		Proveedor prov= new Proveedor();
		Persona per= new Persona();
		per= (Persona)request.getSession(true).getAttribute("usuario");
		if(per==null){
			request.getRequestDispatcher("error-sesion.jsp").forward(request, response);
		}
		int id= Integer.parseInt(request.getParameter("id"));
		prov.setIdProveedor(id);
		prov =ctrl.getById(prov);
		proveedores.add(prov);
		request.setAttribute("descrip", null);
		request.setAttribute("proveedores", proveedores);
		request.getRequestDispatcher("listarProveedores.jsp").forward(request, response);
		
	}

}
