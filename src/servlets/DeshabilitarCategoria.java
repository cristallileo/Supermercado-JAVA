package servlets;

import java.io.IOException;
import java.sql.Timestamp; 
import java.sql.Date;
import java.util.Calendar;
import java.util.LinkedList;

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
 * Servlet implementation class DeshabilitarCategoria
 */
@WebServlet("/DeshabilitarCategoria")
public class DeshabilitarCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeshabilitarCategoria() {
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
		
		CategoriaController ctrl= new CategoriaController();
		ProductoController ctrlProd= new ProductoController();
		Categoria c= new Categoria();
		
		int id= Integer.parseInt(request.getParameter("id"));
		
		c.setIdCategoria(id);
		c =ctrl.getOne(c);
		java.sql.Date ts = new Date(Calendar.getInstance().getTimeInMillis());
		Timestamp timeNow=new Timestamp(ts.getTime());  
		c.setFecha_hora_baja(timeNow);
		c=ctrl.editCategoria(c);
		
		LinkedList<Producto> prods = new LinkedList<Producto>();
		prods= ctrlProd.listarByCategoria(c);
		for (Producto p: prods) {
			
			java.sql.Date ts2 = new Date(Calendar.getInstance().getTimeInMillis());
			Timestamp timeNow2=new Timestamp(ts2.getTime());  
			p.setFecha_hora_baja(timeNow2);
			p=ctrlProd.editProducto(p);
		}
		//request.setAttribute("catDeshabilitada", c);
		request.setAttribute("categorias", ctrl.listAllCategorias());
		request.getRequestDispatcher("listarCategorias.jsp").forward(request, response);
	}

}

