package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Producto;
import logic.CustomException;
import logic.MyHelper;
import logic.ProductoController;

/**
 * Servlet implementation class IngresarStock
 */
@WebServlet("/IngresarStock")
public class IngresarStock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IngresarStock() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Producto prod= new Producto();		
		ProductoController ctrl= new ProductoController();
		MyHelper h = new MyHelper();
		
		int id= Integer.parseInt(request.getParameter("id"));
		prod.setIdProducto(id);
		prod =ctrl.getById(prod);
		
		//int stock = Integer.parseInt(request.getParameter("stock"));
		String stock = request.getParameter("stock");
		
		try {
			h.cantIsNumeric(stock);
		}
		catch (CustomException e1){
			request.setAttribute("message_cantidad",e1.getMessage());
			request.getRequestDispatcher("ingresarStock.jsp").forward(request, response);
		}
		int stock2 = Integer.parseInt(stock);
		int cant= stock2 + prod.getStock();
		prod.setStock(cant);
		
		int id_prov = Integer.parseInt(request.getParameter("prov"));
		prod.setId_provedor(id_prov);
		
		ctrl.agregoStock(prod);
		
		request.getRequestDispatcher("ingresarStock.jsp").forward(request, response);
		
	}

}
