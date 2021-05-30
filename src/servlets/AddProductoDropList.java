package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.Categoria;
import logic.CategoriaController;

@WebServlet("/AddProductoDropList")

public class AddProductoDropList extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public AddProductoDropList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chinchu");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CategoriaController ctrl= new CategoriaController();
		LinkedList<Categoria> categorias= new LinkedList<Categoria>();
		
		categorias= ctrl.listCategoriasActivas();
		
		request.setAttribute("categorias", categorias);
		request.getRequestDispatcher("crearProducto.jsp").forward(request, response);
	}
}
