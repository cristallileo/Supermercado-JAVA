package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Categoria;
import logic.CategoriaController;
import logic.CustomException;
import logic.MyHelper;

/**
 * Servlet implementation class EditEmpleado
 */
@WebServlet("/EditCategoria")
public class EditCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCategoria() {
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

		Categoria cat= new Categoria();
		MyHelper h= new MyHelper();
		CategoriaController ctrl= new CategoriaController();
		
		String descrip= request.getParameter("descrip");
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			h.isCatDuplicada(descrip);
		}
		catch (CustomException e){
			request.setAttribute("message_categoria",e.getMessage());
			request.getRequestDispatcher("BuscarCategoria?id="+ id).forward(request, response);
		}
		
		cat.setIdCategoria(id);
		cat.setDescCategoria(descrip);
		cat=ctrl.editCategoria(cat);
		request.setAttribute("categoriaEditada", cat);
		request.setAttribute("categorias", ctrl.listarCategorias());
		request.getRequestDispatcher("ListCategorias").forward(request, response);
	}

}
