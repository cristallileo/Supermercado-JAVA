package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.Part;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.servlet.annotation.MultipartConfig;
import entidades.Producto;
import logic.ProductoController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@WebServlet("/AddProducto")

public class AddProducto extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public AddProducto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Producto prod = new Producto();
		ProductoController ctrl= new ProductoController();	
		
		String descProd= request.getParameter("descProd");
		int stock = Integer.parseInt(request.getParameter("stock"));
		int stockMin = Integer.parseInt(request.getParameter("stockMin"));
		String marca = request.getParameter("marca");
		int id_categoria = Integer.parseInt(request.getParameter("id_categoria"));
		Double precio= Double.parseDouble(request.getParameter("precio"));	
		//IMAGEN CARGA
		String img = request.getParameter("img");	
		InputStream image = new ByteArrayInputStream(img.getBytes(StandardCharsets.UTF_8));
	
		prod.setDescProducto(descProd);
		prod.setStock(stock);
		prod.setStockMinimo(stockMin);
		prod.setMarca(marca);
		prod.setId_categoria(id_categoria);
		prod.setPrecio(precio);		
		prod.setImagen_carga(image);

		ctrl.addProducto(prod);
		
		request.setAttribute("nuevoProducto", prod);
		request.setAttribute("productos", ctrl.listAllProductos());
		request.getRequestDispatcher("ListProductos").forward(request, response);
	}


}
