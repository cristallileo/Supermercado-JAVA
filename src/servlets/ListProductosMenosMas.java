package servlets;

import java.io.IOException;
import java.util.Collections;
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

@WebServlet("/ListProductosMenosMas")

public class ListProductosMenosMas extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public ListProductosMenosMas() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProductoController ctrl= new ProductoController();
		CategoriaController ctrlCat= new CategoriaController();
		
		LinkedList<Producto> productos= new LinkedList<Producto>();
		LinkedList<Categoria> categorias= new LinkedList<Categoria>();

		productos=ctrl.listarMenosMas();
		categorias= ctrlCat.listCategoriasActivas();
		
		//Collections.sort(lprod);
		
		request.setAttribute("productos", productos);
		request.setAttribute("categorias", categorias);
		
        request.getRequestDispatcher("listarProductos.jsp").forward(request, response);
	}

}
