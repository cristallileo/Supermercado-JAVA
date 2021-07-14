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
 * Servlet implementation class CancelarPedido
 */
@WebServlet("/CancelarPedido")
public class CancelarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CancelarPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PedidoController ctrlPed= new PedidoController();
		LinkedList<Pedido> peds= new LinkedList<Pedido>();
		Pedido ped= new Pedido();
		Persona per = new Persona();
		per= (Persona)request.getSession(true).getAttribute("usuario");
		if(per==null){
			request.getRequestDispatcher("error-sesion.jsp").forward(request, response);
		}
		
		ped=(Pedido)request.getSession(true).getAttribute("pedido");
		ped= ctrlPed.getById(ped);
		ped.setEstado("Cancelado");
		ped.setFechaEntrega(null);
	    ctrlPed.editEstado(ped);
	    
	    per= (Persona)request.getSession(true).getAttribute("usuario");
	    peds= ctrlPed.getByCliente(per);
	    
	    request.getSession(true).setAttribute("pedido", null);
	    request.setAttribute("pedidos", peds);
	    request.setAttribute("confirmado", false);
	    request.setAttribute("cancelado", true);
		request.getRequestDispatcher("mis-pedidos.jsp").forward(request, response);
		
	}

}
