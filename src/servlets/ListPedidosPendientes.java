package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Pedido;
import entidades.Persona;
import logic.PedidoController;

/**
 * Servlet implementation class ListPedidosPendientes
 */
@WebServlet("/ListPedidosPendientes")
public class ListPedidosPendientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPedidosPendientes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PedidoController ctrl= new PedidoController();
		LinkedList<Pedido> pedidos= new LinkedList<Pedido>();
		LinkedList<Pedido> pedidos2= new LinkedList<Pedido>();   
		Persona per= new Persona();
		per= (Persona)request.getSession(true).getAttribute("usuario");
		if(per==null){
			request.getRequestDispatcher("error-sesion.jsp").forward(request, response);
		}

      	pedidos=ctrl.listarPedidos();
      	for(Pedido p: pedidos) {
      	if(p.getEstado().equals("Confirmado")) {
      		pedidos2.add(p);
      	}
      			
      	}
      	request.setAttribute("pedidos", pedidos2);
      	request.getRequestDispatcher("listarPedidos.jsp").forward(request, response);
      	}
		
	}


