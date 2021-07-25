package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.*;
import logic.*;

/**
 * Servlet implementation class ListPedidos
 */
@WebServlet("/ListPedidos")
public class ListPedidos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPedidos() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PedidoController ctrl= new PedidoController();
		LinkedList<Pedido> pedidos= new LinkedList<Pedido>();
		LinkedList<Pedido> pedidos2= new LinkedList<Pedido>();        
		//Veo a donde lo direcciono:
      		Persona per= new Persona();
      		
      		per= (Persona)request.getSession(true).getAttribute("usuario");
      		if(per==null){
    			request.getRequestDispatcher("error-sesion.jsp").forward(request, response);
    		}else if(per.isCliente()==true) {
      			pedidos=ctrl.getByCliente(per);
      			request.setAttribute("pedidos", pedidos);
      			request.setAttribute("confirmado", false);
      			request.setAttribute("cancelado", false);
      			request.getRequestDispatcher("mis-pedidos.jsp").forward(request, response);
      			
      		}else  if (per.isEmpleado()==true){
      			pedidos=ctrl.listarPedidos();
      			for(Pedido p: pedidos) {
      				if(p.getEstado().equals("Confirmado") || p.getEstado().equals("Despachado")|| p.getEstado().equals("Entregado")) {
      					pedidos2.add(p);
      				} 
      			}
      	      	request.setAttribute("pedidos", pedidos2);
      	      	request.getRequestDispatcher("listarPedidos.jsp").forward(request, response);
      		}


	}
}
