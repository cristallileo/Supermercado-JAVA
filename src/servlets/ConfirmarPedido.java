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
		ProductoController ctrlPro = new ProductoController();
		LineaDePedidoController ctrlLinea = new LineaDePedidoController();
		LinkedList<LineaDePedido> lineas= new LinkedList<LineaDePedido>();
		LinkedList<Pedido> peds= new LinkedList<Pedido>();
		Pedido ped= new Pedido();
		Persona per = new Persona();
		per= (Persona)request.getSession(true).getAttribute("usuario");
		if(per==null){
			request.getRequestDispatcher("error-sesion.jsp").forward(request, response);
		}
		
		ped=(Pedido)request.getSession(true).getAttribute("pedido");
		ped= ctrlPed.getById(ped);
		ped.setDireccionEnvio(request.getParameter("direc"));
		if(ped.getId_dcto()!=0) {
			Descuento d= new Descuento();
			DescuentoController ctrldes= new DescuentoController();
			d.setIdDcto(ped.getId_dcto());
			d= ctrldes.getById(d);
			double total= ped.getPrecioTotal() * (1- d.getPorcDcto());
			ped.setPrecioTotal(total);
			ctrlPed.editTotal(ped);
		}
		//ped.getPrecioTotal()
	    ctrlPed.confirmarPedido(ped);	    
	    lineas = ctrlLinea.getByPedido(ped);
	    ctrlPro.actualizarStock(lineas);
	    
	    peds= ctrlPed.getByCliente(per);
	    
	    request.getSession(true).setAttribute("pedido", null);
	    //request.setAttribute("usuario", o);
	    request.setAttribute("pedidos", peds);
	    request.setAttribute("confirmado", true);
	    request.setAttribute("cancelado", false);
		request.getRequestDispatcher("mis-pedidos.jsp").forward(request, response);
	}

}
