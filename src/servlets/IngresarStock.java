package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Persona;
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
		
		Persona per= new Persona();
		per= (Persona)request.getSession(true).getAttribute("usuario");
		if(per==null){
			request.getRequestDispatcher("error-sesion.jsp").forward(request, response);
		}
		
		int id= Integer.parseInt(request.getParameter("id"));
		prod.setIdProducto(id);
		prod =ctrl.getById(prod);
		
		//int stock = Integer.parseInt(request.getParameter("stock"));
		String stock = request.getParameter("stock");
		
		if(h.isNumeric(stock)==false) {
			request.setAttribute("message_cantidad","El campo cantidad debe ser numérico.");
			request.getRequestDispatcher("ingresarStock.jsp").forward(request, response);
		}else {
		int stock2 = Integer.parseInt(stock);
		int cant= stock2 + prod.getStock();
		prod.setStock(cant);
		
		Integer id_prov = Integer.parseInt(request.getParameter("prov"));
		prod.setId_proveedor(id_prov);
		
		ctrl.agregoStock(prod);
		
		request.getRequestDispatcher("ingresarStock.jsp").forward(request, response);
		}
	}

}
