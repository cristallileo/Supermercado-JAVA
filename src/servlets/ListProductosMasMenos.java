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
 * Servlet implementation class ListProductosMasMenos
 */
@WebServlet("/ListProductosMasMenos")
public class ListProductosMasMenos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProductosMasMenos() {
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
		//doGet(request, response);
		ProductoController ctrl= new ProductoController();
		CategoriaController ctrlCat= new CategoriaController();
		
		LinkedList<Producto> productos= new LinkedList<Producto>();
		LinkedList<Categoria> categorias= new LinkedList<Categoria>();
		
		productos=ctrl.listarMasMenos();
	        
        //Veo a donde lo direcciono:
      		Persona per= new Persona();
      		per= (Persona)request.getSession(true).getAttribute("usuario");
      		
      		// si es cliente solo me traigo las categorias y los productos activos
      		
      		if(per.isCliente()==true) {
      			categorias= ctrlCat.listCategoriasActivas();
    			categorias=ctrlCat.listCategoriasNoVacias(categorias);
      			request.setAttribute("categorias", categorias);
      			
      			LinkedList<Producto> prods_activos= new LinkedList<Producto>();
      			for (Producto p: productos) {
      				if (p.getFecha_hora_baja()==null) {
      					prods_activos.add(p);
      				}
      			}
      			 request.setAttribute("productos", prods_activos);
      			 request.getRequestDispatcher("productos.jsp").forward(request, response);
      			 
      			 //si es empleado traigo activos y no activos
      			
      		}else {
      			categorias=ctrlCat.listAllCategorias();
      			request.setAttribute("categorias", categorias);
      			request.setAttribute("productos", productos);
      			request.getRequestDispatcher("listarProductos.jsp").forward(request, response);
      		}
	}

}
