package servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.*;
import logic.*;

@WebServlet("/ListProductos")

public class ListProductos extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public ListProductos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProductoController ctrl= new ProductoController();
		CategoriaController ctrlCat= new CategoriaController();
		
		LinkedList<Producto> productos= new LinkedList<Producto>();
		LinkedList<Categoria> categorias= new LinkedList<Categoria>();
		
		request.setAttribute("descrip", null);
		
		//Veo a donde lo direcciono:
		Persona per= new Persona();
		per= (Persona)request.getSession(true).getAttribute("usuario");
		if(per==null){
			request.getRequestDispatcher("error-sesion.jsp").forward(request, response);
		}else 
		if(per.isCliente()==true) {
			productos= ctrl.listAllProductos();
			categorias= ctrlCat.listCategoriasActivas();
			categorias=ctrlCat.listCategoriasNoVacias(categorias);
			LinkedList<Producto> prods_activos= new LinkedList<Producto>();
			for (Producto prod: productos) {
				//Mostrarle al cliente solo los prods activos y que tengan al menos una unidad en stock
				if (prod.getFecha_hora_baja()==null) {
					if(prod.getStock()>=1) {
					prods_activos.add(prod);
					}
				}
			}	
			Pedido p = new Pedido();
			p= (Pedido) request.getAttribute("pedido");
			request.setAttribute("pedido", p);

			request.setAttribute("categorias", categorias);
			request.setAttribute("productos", prods_activos);
			request.getRequestDispatcher("productos.jsp").forward(request, response);
			
			 //request.setAttribute("pedido", null);
		}else if (per.isEmpleado()==true){
			 productos=ctrl.listAllProductos();
			
			 categorias= ctrlCat.listAllCategorias();
			 request.setAttribute("productos", productos);
			 request.setAttribute("categorias", categorias);
			 request.getRequestDispatcher("listarProductos.jsp").forward(request, response);
		
			 
		}
}
}