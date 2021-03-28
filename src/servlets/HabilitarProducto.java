package servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Categoria;
import entidades.Producto;
import logic.CategoriaController;
import logic.ProductoController;

/**
 * Servlet implementation class HabilitarProducto
 */
@WebServlet("/HabilitarProducto")
public class HabilitarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HabilitarProducto() {
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

		ProductoController ctrl= new ProductoController();
		CategoriaController ctrlCat = new CategoriaController();
		Categoria c= new Categoria();
		Producto p= new Producto();
		
		int id= Integer.parseInt(request.getParameter("id"));
		
		p.setIdProducto(id);
		p=ctrl.getById(p);
		c= ctrl.getCategoria(p);
		if (c.getFecha_hora_baja()==null) {
			p.setFecha_hora_baja(null);
			p=ctrl.editProducto(p);
			//request.setAttribute("catDeshabilitada", c);
			request.setAttribute("productos", ctrl.listAllProductos());
			request.setAttribute("categorias", ctrlCat.listAllCategorias());
			request.getRequestDispatcher("listarProductos.jsp").forward(request, response);
		}else {
			
			request.getRequestDispatcher("error-prod-cat.jsp").forward(request, response);;
		}
		 
	

}


}
