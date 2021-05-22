package servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.LineaDePedido;
import entidades.Pedido;
import entidades.Producto;
import logic.LineaDePedidoController;
import logic.ProductoController;

/**
 * Servlet implementation class QuitarProducto
 */
@WebServlet("/QuitarProducto")
public class QuitarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuitarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductoController ctrlProd= new ProductoController();
		Producto prod= new Producto();
		LineaDePedidoController ctrlLinea = new LineaDePedidoController();
		LinkedList<LineaDePedido> lineas= new LinkedList<LineaDePedido>();
		Pedido ped= new Pedido();		
		
		//Busco en la bdd cual es el producto que quiero sacar del pedido 
		int id = Integer.parseInt(request.getParameter("idProd"));
		prod.setIdProducto(id);
		prod=ctrlProd.getById(prod);
		
		//Traigo mi pedido actual
		ped=(Pedido)request.getSession(true).getAttribute("pedido");
		
		//traigo todas las lineas de mi pedido actual
		lineas= ctrlLinea.getByPedido(ped);
		
		//veo cual el la linea que tengo q eliminar
		for(LineaDePedido linea: lineas) {
			if(linea.getId_producto()==prod.getIdProducto()) {
				java.sql.Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());
				linea.setFecha_hora_baja(timeNow);
				linea=ctrlLinea.darDeBaja(linea);
			}
		}
		
		request.setAttribute("lineas",lineas );
		request.getRequestDispatcher("carrito.jsp").forward(request, response);
	}

}
