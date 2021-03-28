package servlets;

import java.io.IOException;
import java.sql.Timestamp; 
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Categoria;
import logic.CategoriaController;

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
		Categoria c= new Categoria();
		
		int id= Integer.parseInt(request.getParameter("id"));
		
		c.setIdCategoria(id);
		c =ctrl.getOne(c);
		
		//Date hoy = new Date(System.currentTimeMillis()); 
		//java.sql.Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());
		java.sql.Date ts = new Date(Calendar.getInstance().getTimeInMillis());
		Timestamp timeNow=new Timestamp(ts.getTime());  
		c.setFecha_hora_baja(timeNow);
		c=ctrl.editCategoria(c);
		//request.setAttribute("catDeshabilitada", c);
		request.setAttribute("categorias", ctrl.listAllCategorias());
		request.getRequestDispatcher("listarCategorias.jsp").forward(request, response);
	}

}
