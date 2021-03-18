package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.Pedido;
import logic.PedidoController;

@WebServlet("/BuscarPedido")

public class BuscarPedido extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public BuscarPedido() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PedidoController ctrl= new PedidoController();
		Pedido ped= new Pedido();
		int id= Integer.parseInt(request.getParameter("id"));
		ped.setIdPedido(id);
		ped =ctrl.getById(ped);
		request.setAttribute("descuentoEditar", ped);
		request.getRequestDispatcher("editarDescuento.jsp").forward(request, response);
	}

}
