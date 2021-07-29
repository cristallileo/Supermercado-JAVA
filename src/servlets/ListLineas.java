package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.LineaDePedido;
import entidades.Pedido;
import entidades.Persona;
import logic.LineaDePedidoController;
import logic.PedidoController;

/**
 * Servlet implementation class ListLineas
 */
@WebServlet("/ListLineas")
public class ListLineas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListLineas() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Persona per= new Persona();
  		per= (Persona)request.getSession(true).getAttribute("usuario");
  		if(per==null) {
  			request.getRequestDispatcher("error-session.jsp").forward(request, response);
  		}else {
		PedidoController ctrl= new PedidoController();
		Pedido ped= new Pedido();
		int id= Integer.parseInt(request.getParameter("id"));
		ped.setIdPedido(id);
		ped =ctrl.getById(ped);
		if(ped==null) {
			request.getRequestDispatcher("error-gral.jsp").forward(request, response);
		}else {
			LinkedList<LineaDePedido> lineas= new LinkedList<LineaDePedido>();
			LineaDePedidoController ctrlL= new LineaDePedidoController();
			lineas=ctrlL.getByPedido(ped);
			
  			request.setAttribute("lineas", lineas);
  			request.getRequestDispatcher("listarLineas.jsp").forward(request, response);
		}
		}
	}

}
