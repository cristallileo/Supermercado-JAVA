package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Categoria;
import logic.CategoriaController;

@WebServlet("/DeleteCategoria")

public class DeleteCategoria extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    public DeleteCategoria() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CategoriaController ctrl= new CategoriaController();
		Categoria cat = new Categoria();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		cat.setIdCategoria(id);
		cat =ctrl.getOne(cat);
		cat=ctrl.deleteCategoria(cat);

		
		request.setAttribute("categorias", ctrl.listCategoriasActivas());
		request.getRequestDispatcher("ListCategorias").forward(request, response);	
	}
}
