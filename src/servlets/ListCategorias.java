package servlets;

import java.io.IOException;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.*;
import logic.CategoriaController;

@WebServlet("/ListCategorias")

public class ListCategorias extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public ListCategorias() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		CategoriaController ctrl= new CategoriaController();
		LinkedList<Categoria> categorias= new LinkedList<Categoria>();
		Persona per= new Persona();
		per= (Persona)request.getSession(true).getAttribute("usuario");
		if(per==null){
			request.getRequestDispatcher("error-sesion.jsp").forward(request, response);
		}
		categorias=ctrl.listAllCategorias();
		
		
		request.setAttribute("descrip", null);
		request.setAttribute("categorias", categorias);
        request.getRequestDispatcher("listarCategorias.jsp").forward(request, response);       
	
	}
}