package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.Producto;
import logic.ProductoController;

@WebServlet("/DeleteProducto")

public class DeleteProducto extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public DeleteProducto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ProductoController ctrl= new ProductoController();
		Producto prod= new Producto();
		int id = Integer.parseInt(request.getParameter("id"));
		prod.setIdProducto(id);
		prod=ctrl.getById(prod);
		prod=ctrl.deleteProducto(prod);
		
		request.setAttribute("productos", ctrl.listAllProductos());
		request.getRequestDispatcher("ListProductos").forward(request, response);
				
	}

}


