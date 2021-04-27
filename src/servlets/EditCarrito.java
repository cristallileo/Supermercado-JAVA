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
import logic.LineaDePedidoController;
import logic.PedidoController;

/**
 * Servlet implementation class EditCarrito
 */
@WebServlet("/EditCarrito")
public class EditCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCarrito() {
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
		// TODO Auto-generated method stub
		
		//PedidoController ctrlPed= new PedidoController();
		
		LineaDePedidoController ctrl= new LineaDePedidoController();
		LineaDePedido lp= new LineaDePedido();
		
		int idProd=Integer.parseInt(request.getParameter("idProd")); //java.lang.NumberFormatException: null; idProd is null
		int cant=Integer.parseInt(request.getParameter("cant"));
		Pedido ped=(Pedido)request.getSession(true).getAttribute("pedido");
		
		lp= ctrl.getByPK(ped,idProd);
		lp.setCantidad(cant);
		lp=ctrl.editLineaDePedido(lp);
	    
		request.getRequestDispatcher("carrito.jsp").forward(request, response);
		
		
		
		
	}

}
