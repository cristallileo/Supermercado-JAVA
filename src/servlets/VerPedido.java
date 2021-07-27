package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.*;
import logic.LineaDePedidoController;

/**
 * Servlet implementation class VerPedido
 */
@WebServlet("/VerPedido")
public class VerPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerPedido() {
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
		LinkedList<LineaDePedido> lineas= new LinkedList<LineaDePedido>();
		LineaDePedidoController ctrlLinea= new LineaDePedidoController();
		Pedido ped= new Pedido();		
		Persona per= new Persona();
		per= (Persona)request.getSession(true).getAttribute("usuario");
		if(per==null){
			request.getRequestDispatcher("error-sesion.jsp").forward(request, response);
		}
		ped=(Pedido)request.getSession(true).getAttribute("pedido");
		if(ped!=null) {
		lineas= ctrlLinea.getByPedido(ped);
		if(lineas.size()>=1) {
		request.setAttribute("lineas",lineas );
		request.setAttribute("prod_eliminado", false );
		request.getRequestDispatcher("carrito.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("error-gral-cliente.jsp").forward(request, response);
		}
		}else {
			request.getRequestDispatcher("error-gral-cliente.jsp").forward(request, response);
		}
}
}