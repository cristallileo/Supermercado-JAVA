package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Descuento;
import entidades.Pedido;
import entidades.Persona;
import logic.DescuentoController;
import logic.PedidoController;
import logic.PersonaController;

/**
 * Servlet implementation class BuscarPedido
 */
@WebServlet("/BuscarPedido")
public class BuscarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		PedidoController ctrl= new PedidoController();
		Pedido ped= new Pedido();
		int id= Integer.parseInt(request.getParameter("id"));
		ped.setIdPedido(id);
		ped =ctrl.getById(ped);
		request.setAttribute("descuentoEditar", ped);
		request.getRequestDispatcher("editarDescuento.jsp").forward(request, response);
	}

}
