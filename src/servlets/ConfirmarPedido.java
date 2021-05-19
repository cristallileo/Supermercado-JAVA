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
 * Servlet implementation class ConfirmarPedido
 */
@WebServlet("/ConfirmarPedido")
public class ConfirmarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmarPedido() {
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
		
		PedidoController ctrlPed= new PedidoController();
		LinkedList<Pedido> peds= new LinkedList<Pedido>();
		Pedido ped= new Pedido();
		Persona per = new Persona();
		
		ped=(Pedido)request.getSession(true).getAttribute("pedido");
		ped= ctrlPed.getById(ped);
		ped.setDireccionEnvio(request.getParameter("direc"));
	    ctrlPed.confirmarPedido(ped);
	    
	    per= (Persona)request.getSession(true).getAttribute("usuario");
	    peds= ctrlPed.getByCliente(per);
	    
	    request.getSession(true).setAttribute("pedido", null);
	    //request.setAttribute("usuario", o);
	    request.setAttribute("pedidos", peds);
	    request.setAttribute("mensaje", "Su pedido ha sido registrado con éxito.");
		request.getRequestDispatcher("mis-pedidos.jsp").forward(request, response);
	}

}
