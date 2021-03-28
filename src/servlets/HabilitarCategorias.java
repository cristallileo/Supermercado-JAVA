package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Categoria;
import entidades.Proveedor;
import logic.CategoriaController;
import logic.ProveedorController;

/**
 * Servlet implementation class HabilitarCategorias
 */
@WebServlet("/HabilitarCategorias")
public class HabilitarCategorias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HabilitarCategorias() {
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
		c.setFecha_hora_baja(null);
		c=ctrl.editCategoria(c);
		request.setAttribute("catHabilitada", c);
		request.setAttribute("categorias", ctrl.listAllCategorias());
		request.getRequestDispatcher("ListCategorias").forward(request, response);
	}

}
