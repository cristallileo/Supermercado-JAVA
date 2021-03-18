package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.Categoria;
import logic.CategoriaController;

@WebServlet("/AddCategoria")

public class AddCategoria extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public AddCategoria() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Categoria cat= new Categoria();
		CategoriaController ctrl= new CategoriaController();
		
		String desc_categoria = request.getParameter("descrip");
				
		cat.setDescCategoria(desc_categoria);
		ctrl.addCategoria(cat);
		request.setAttribute("nuevaCategoria", cat);
		request.setAttribute("categorias", cat);
		request.getRequestDispatcher("ListCategorias").forward(request, response);
						
		}
	
			//cartel de q esta mal
		
	}


