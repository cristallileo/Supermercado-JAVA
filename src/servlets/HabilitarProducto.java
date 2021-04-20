package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.Categoria;
import entidades.Producto;
import logic.CategoriaController;
import logic.ProductoController;

@WebServlet("/HabilitarProducto")

public class HabilitarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HabilitarProducto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProductoController ctrl= new ProductoController();
		CategoriaController ctrlCat = new CategoriaController();
		Categoria c= new Categoria();
		Producto p= new Producto();
		
		int id= Integer.parseInt(request.getParameter("id"));
		
		p.setIdProducto(id);
		p=ctrl.getById(p);
		c= ctrl.getCategoria(p);
		if (c.getFecha_hora_baja()==null) {
			p.setFecha_hora_baja(null);
			p=ctrl.editProducto(p);
			//request.setAttribute("catDeshabilitada", c);
			request.setAttribute("productos", ctrl.listAllProductos());
			request.setAttribute("categorias", ctrlCat.listAllCategorias());
			request.getRequestDispatcher("listarProductos.jsp").forward(request, response);
		}else {
			
			request.getRequestDispatcher("error-prod-cat.jsp").forward(request, response);;
		}
		 
	

}


}
