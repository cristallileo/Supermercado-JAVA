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
		MyHelper h= new MyHelper();
		
		String desc_categoria = request.getParameter("descrip");
				
		try {
			h.isCatDuplicada(desc_categoria);
		}
		catch (CustomException e){
			request.setAttribute("message_categoria",e.getMessage());
			request.getRequestDispatcher("crearCategoria.jsp").forward(request, response);
		}
		
		cat.setDescCategoria(desc_categoria);
		ctrl.addCategoria(cat);
		request.setAttribute("nuevaCategoria", cat);
		request.setAttribute("categorias", cat);
		request.getRequestDispatcher("ListCategorias").forward(request, response);
						
		}
	
			//cartel de q esta mal
		
	}


