package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Producto;
import logic.ProductoController;

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
		
		ProductoController ctrl= new ProductoController();
		Producto prod= new Producto();
		int id= Integer.parseInt(request.getParameter("id"));
		prod.setIdProducto(id);
		prod =ctrl.getById(prod);
		
		if(prod==null) {
			
			request.getRequestDispatcher("error-consulta.jsp").forward(request, response);
		}else {
			request.setAttribute("encontrado", true);
			request.setAttribute("prod", prod);
			request.getRequestDispatcher("ingresarStock2.jsp").forward(request, response);
		}
			
		
	}

}
