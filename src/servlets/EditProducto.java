package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Descuento;
import entidades.Producto;
import logic.DescuentoController;
import logic.ProductoController;

/**
 * Servlet implementation class EditProducto
 */
@WebServlet("/EditProducto")
public class EditProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		Producto prod= new Producto();		
		ProductoController ctrl= new ProductoController();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String descProd= request.getParameter("descProd");
		int stock = Integer.parseInt(request.getParameter("stock"));
		int stockMin = Integer.parseInt(request.getParameter("stockMin"));
		String marca = request.getParameter("marca");
		int categ = Integer.parseInt(request.getParameter("categ"));
		Double precio= Double.parseDouble(request.getParameter("precio"));					
				
	    prod.setIdProducto(id);
	    prod.setDescProducto(descProd);
	    prod.setStock(stock);
	    prod.setStockMinimo(stockMin);
	    prod.setMarca(marca);
	    prod.setId_categoria(categ);
	    prod.setPrecio(precio);
	    
	    // PrintWriter writer = response.getWriter();
	    // writer.println(id);
	    
	    // response.getWriter().append("Hola");
	   
	    prod=ctrl.editProducto(prod);

		request.setAttribute("producto-editado", prod);
		request.setAttribute("productos", ctrl.listarProductos());
		request.getRequestDispatcher("ListProductos").forward(request, response);
		
		
	}

}


