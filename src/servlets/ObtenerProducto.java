package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Persona;
import entidades.Producto;
import entidades.Proveedor;
import logic.ProductoController;
import logic.ProveedorController;

/**
 * Servlet implementation class ObtenerProducto
 */
@WebServlet("/ObtenerProducto")
public class ObtenerProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public ObtenerProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Persona per= new Persona();
		per= (Persona)request.getSession(true).getAttribute("usuario");
		if(per==null){
			request.getRequestDispatcher("error-sesion.jsp").forward(request, response);
		}
		ProductoController ctrl= new ProductoController();
		Producto prod= new Producto();
		LinkedList<Proveedor> lprov = new LinkedList<Proveedor>();
		ProveedorController ctrlProv= new ProveedorController();
		
		int id= Integer.parseInt(request.getParameter("id"));
		prod.setIdProducto(id);
		prod =ctrl.getById(prod);
		lprov= ctrlProv.listarActivos();
		
		if(prod==null) {
			
			request.getRequestDispatcher("error-consulta.jsp").forward(request, response);
		}else {
			request.setAttribute("encontrado", true);
			request.setAttribute("proveedores", lprov);
			request.setAttribute("prod", prod);
			request.getRequestDispatcher("ingresarStock2.jsp").forward(request, response);
		}
			
		
	}

}
