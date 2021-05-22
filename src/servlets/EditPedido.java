package servlets;

import java.io.IOException;
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
		
		ProductoController ctrlProd= new ProductoController();
		Producto prod= new Producto();
		LinkedList<LineaDePedido> lineas= new LinkedList<LineaDePedido>();
		LineaDePedidoController ctrlLinea= new LineaDePedidoController();
		Pedido ped= new Pedido();		
		
		ped=(Pedido)request.getSession(true).getAttribute("pedido");
		lineas= ctrlLinea.getByPedido(ped);
		
		int id = Integer.parseInt(request.getParameter("idProd"));
		prod.setIdProducto(id);
		prod=ctrlProd.getById(prod);
		
		request.setAttribute("lineas",lineas );
		request.setAttribute("prodEditar", prod);
	}

}
