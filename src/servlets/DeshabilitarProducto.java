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

import entidades.Producto;
import logic.CategoriaController;
import logic.ProductoController;

/**
 * Servlet implementation class DeshabilitarProducto
 */
@WebServlet("/DeshabilitarProducto")
public class DeshabilitarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeshabilitarProducto() {
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
		Producto p= new Producto();
		CategoriaController ctrlCat = new CategoriaController();
		
		int id= Integer.parseInt(request.getParameter("id"));
		
		p.setIdProducto(id);
		p=ctrl.getById(p);
		
		//Date hoy = new Date(System.currentTimeMillis()); 
		//java.sql.Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());
		java.sql.Date ts = new Date(Calendar.getInstance().getTimeInMillis());
		Timestamp timeNow=new Timestamp(ts.getTime());  
		p.setFecha_hora_baja(timeNow);
		p=ctrl.editProducto(p);
		//request.setAttribute("catDeshabilitada", c);
		request.setAttribute("productos", ctrl.listAllProductos());
		request.setAttribute("categorias", ctrlCat.listAllCategorias());
		request.getRequestDispatcher("listarProductos.jsp").forward(request, response);
	}

}

