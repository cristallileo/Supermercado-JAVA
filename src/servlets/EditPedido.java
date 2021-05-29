package servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.*;
import entidades.*;

/**
 * Servlet implementation class EditPedido
 */
@WebServlet("/EditPedido")
public class EditPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPedido() {
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
		
		//ProductoController ctrlProd= new ProductoController();
		//Producto prod= new Producto();
		//LinkedList<LineaDePedido> lineas= new LinkedList<LineaDePedido>();
		//LineaDePedidoController ctrlLinea= new LineaDePedidoController();
		Pedido ped= new Pedido();
		PedidoController ctrlPed= new PedidoController();
		int id = Integer.parseInt(request.getParameter("id"));
		ped.setIdPedido(id);
		ped= ctrlPed.getById(ped);
		
		Persona per= new Persona();
		per= (Persona)request.getSession(true).getAttribute("usuario");
		
		if(per.isCliente()==true) {
			
			
		}else {
			
			String est1 = request.getParameter("estado1");
			String est2 = request.getParameter("estado2");
			String fecha_envio = request.getParameter("fechaenvio");
			
			if(est1==null) {
				if(est2==null) {
					//ver
				}else {
					Date fec_env = Date.valueOf(fecha_envio);
					ped.setEstado(est2);
					ped.setFechaEntrega(fec_env);
				}
			}else {
				ped.setEstado(est1);
			}
			
			ctrlPed.editEstado(ped);			
		}
		
		request.getRequestDispatcher("ListPedidos").forward(request, response);		
	}

}
