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

@WebServlet("/ListProductosDesc")

public class ListProductosDesc extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public ListProductosDesc() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		ProductoController ctrl= new ProductoController();
		CategoriaController ctrlCat= new CategoriaController();
		
		LinkedList<Producto> productos= new LinkedList<Producto>();
		LinkedList<Categoria> categorias= new LinkedList<Categoria>();
		
		String desc= request.getParameter("search");
		productos=ctrl.listarByDesc(desc);
		//request.setAttribute("descrip", null);
		request.setAttribute("descrip", desc);
		
		//Veo a donde lo direcciono:
		Persona per= new Persona();
		per= (Persona)request.getSession(true).getAttribute("usuario");
		if(per.isCliente()==true) {
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
			
			 //request.setAttribute("pedido", null);
		}else {			

			 request.setAttribute("productos", productos);
			 request.setAttribute("categorias", categorias);
			 request.getRequestDispatcher("listarProductos.jsp").forward(request, response);
		}
	}

}

