package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.*;
import logic.*;

/**
 * Servlet implementation class AddLinea
 */
@WebServlet("/AddLinea")
public class AddLinea extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLinea() {
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
		LineaDePedido lp= new LineaDePedido();
		LineaDePedidoController ctrl= new LineaDePedidoController();
		ProductoController ctrlProd= new ProductoController();
		CategoriaController ctrlCat= new CategoriaController();
		PedidoController ctrlPed= new PedidoController();
		Producto p = new Producto();
		Pedido ped = new Pedido();
		
		int idProd= Integer.parseInt(request.getParameter("idProd"));
		p.setIdProducto(idProd);
		p= ctrlProd.getById(p);
		
		ped= (Pedido)request.getSession(true).getAttribute("pedido");
		ped=ctrlPed.getById(ped);
		
		int cant= Integer.parseInt(request.getParameter("cant"));
		
		//CHEQUEO SI HAY ESA CANTIDAD EN STOCK
		
		lp.setId_producto(p.getIdProducto());
		lp.setId_pedido(ped.getIdPedido());
		lp.setCantidad(cant);
			
		ctrl.addLinea(lp);
			
		//HAGO CALCULOS DE PRECIOS PARA SUMAR AL SUBTOTAL DE Pedido
		double subtot= cant* p.getPrecio();
		ped.setPrecioTotal(ped.getPrecioTotal()+subtot);
		ctrlPed.editTotal(ped);
		
		LinkedList<Producto> productos= new LinkedList<Producto>();
		LinkedList<Categoria> categorias= new LinkedList<Categoria>();
		productos= ctrlProd.listAllProductos();
		categorias= ctrlCat.listCategoriasActivas();
		categorias=ctrlCat.listCategoriasNoVacias(categorias);
		LinkedList<Producto> prods_activos= new LinkedList<Producto>();
		for (Producto prod: productos) {
			if (prod.getFecha_hora_baja()==null) {
				prods_activos.add(prod);
			}
		}	
		//p= (Pedido) request.getAttribute("pedido");
		//request.setAttribute("pedido", ped);
		
		request.setAttribute("categorias", categorias);
		request.setAttribute("productos", prods_activos);
		HttpSession session = request.getSession(true);				
		session.setAttribute("pedido", ped);
		//request.setAttribute("agregado",true);
		request.getRequestDispatcher("productos.jsp").forward(request, response);
	}

}
