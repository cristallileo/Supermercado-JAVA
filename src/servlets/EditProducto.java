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
		prod.setIdProducto(id);
		prod= ctrl.getById(prod);
		
		String descProd= request.getParameter("descProd");
		int stockMin = Integer.parseInt(request.getParameter("stockMin"));
		String marca = request.getParameter("marca");
		int categ = Integer.parseInt(request.getParameter("id_categoria"));
		Double precio= Double.parseDouble(request.getParameter("precio"));		
		
	    prod.setDescProducto(descProd);
	    prod.setStockMinimo(stockMin);
	    prod.setMarca(marca);
	    prod.setId_categoria(categ);
	    prod.setPrecio(precio);	

	    boolean isthereafile = false;
	    Part Archivo =  request.getPart("foto");
		if(Archivo.getSize()>0){
		isthereafile = true;
		InputStream inputstream = Archivo.getInputStream();
		prod.setImagen_carga(inputstream);
		}
		if(Archivo.getSize()<=0){
		isthereafile = false;
		}
				
	    prod=ctrl.editProducto(prod, isthereafile);

		request.setAttribute("producto-editado", prod);
		request.setAttribute("productos", ctrl.listAllProductos());
		request.getRequestDispatcher("ListProductos").forward(request, response);
				
	}

}


