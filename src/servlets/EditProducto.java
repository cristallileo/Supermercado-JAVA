package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import entidades.Producto;
import logic.ProductoController;
import java.io.IOException;
import java.io.InputStream;


@WebServlet("/EditProducto")
@MultipartConfig
public class EditProducto extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public EditProducto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Producto prod= new Producto();		
		ProductoController ctrl= new ProductoController();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String descProd= request.getParameter("descProd");
		int stock = Integer.parseInt(request.getParameter("stock"));
		int stockMin = Integer.parseInt(request.getParameter("stockMin"));
		String marca = request.getParameter("marca");
		int categ = Integer.parseInt(request.getParameter("id_categoria"));
		Double precio= Double.parseDouble(request.getParameter("precio"));					
				
	    prod.setIdProducto(id);
	    prod.setDescProducto(descProd);
	    prod.setStock(stock);
	    prod.setStockMinimo(stockMin);
	    prod.setMarca(marca);
	    prod.setId_categoria(categ);
	    prod.setPrecio(precio);	

		Part Archivo =  request.getPart("foto");
		InputStream inputstream = Archivo.getInputStream();
		prod.setImagen_carga(inputstream);
		
	    prod=ctrl.editProducto(prod);

		request.setAttribute("producto-editado", prod);
		request.setAttribute("productos", ctrl.listAllProductos());
		request.getRequestDispatcher("ListProductos").forward(request, response);
				
	}

}


