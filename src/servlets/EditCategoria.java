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

@WebServlet("/EditCategoria")

public class EditCategoria extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public EditCategoria() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

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
		request.setAttribute("categorias", ctrl.listCategoriasActivas());
		request.getRequestDispatcher("ListCategorias").forward(request, response);
	}

}
