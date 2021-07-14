package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Descuento;
import entidades.Pedido;
import entidades.Persona;
import logic.DescuentoController;

/**
 * Servlet implementation class ListDescuentosActivos
 */
@WebServlet("/ListDescuentosActivos")
public class ListDescuentosActivos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListDescuentosActivos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DescuentoController ctrl= new DescuentoController();
		LinkedList<Descuento> descuentos= new LinkedList<Descuento>();
		Persona per= new Persona();
		per= (Persona)request.getSession(true).getAttribute("usuario");
		if(per==null){
			request.getRequestDispatcher("error-sesion.jsp").forward(request, response);
		}else 
	
		descuentos=ctrl.listarDescuentosAct();
		request.setAttribute("descuentos", descuentos);
		request.getRequestDispatcher("listarDescuentos.jsp").forward(request, response);
				
		
	}

}
