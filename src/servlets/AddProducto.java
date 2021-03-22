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
 * Servlet implementation class AddProducto
 */
@WebServlet("/AddProducto")
public class AddProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		Producto prod = new Producto();
		ProductoController ctrl= new ProductoController();	
		
		String descProd= request.getParameter("descProd");
		int stock = Integer.parseInt(request.getParameter("stock"));
		int stockMin = Integer.parseInt(request.getParameter("stockMin"));
		String marca = request.getParameter("marca");
		int id_categoria = Integer.parseInt(request.getParameter("id_categoria"));
		Double precio= Double.parseDouble(request.getParameter("precio"));					
				
		prod.setDescProducto(descProd);
		prod.setStock(stock);
		prod.setStockMinimo(stockMin);
		prod.setMarca(marca);
		
		prod.setId_categoria(id_categoria);
		
		prod.setPrecio(precio);

		ctrl.addProducto(prod);
		
		request.setAttribute("nuevoProducto", prod);
		request.setAttribute("productos", ctrl.listarProductos());
		request.getRequestDispatcher("ListProductos").forward(request, response);
	}

}
