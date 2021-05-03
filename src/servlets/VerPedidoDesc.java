package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Categoria;
import entidades.Persona;
import entidades.Producto;
import logic.CategoriaController;
import logic.ProductoController;

/**
 * Servlet implementation class VerPedidoDesc
 */
@WebServlet("/VerPedidoDesc")
public class VerPedidoDesc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerPedidoDesc() {
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
	
		ProductoController ctrl= new ProductoController();
		CategoriaController ctrlCat= new CategoriaController();
		
		LinkedList<Producto> prods_carrito= new LinkedList<Producto>();
		LinkedList<Producto> productos= new LinkedList<Producto>();
		LinkedList<Categoria> categorias= new LinkedList<Categoria>();
		
		prods_carrito= request.getParameter("prods_carrito");
		String desc= request.getParameter("search");
		productos=ctrl.listarByDesc(desc);
		request.setAttribute("descrip", desc);
		
		
		categorias= ctrlCat.listCategoriasActivas();
		categorias=ctrlCat.listCategoriasNoVacias(categorias);
		
		
		
		
		LinkedList<Producto> prods_activos= new LinkedList<Producto>();
		for (Producto prod: productos) {
			if (prod.getFecha_hora_baja()==null) {
				prods_activos.add(prod);
			}
		}	

		request.setAttribute("categorias", categorias);
		request.setAttribute("productos", prods_activos);
		request.getRequestDispatcher("productos.jsp").forward(request, response);
	
}}
