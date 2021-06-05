package servlets;

import java.io.IOException;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.*;
import logic.*;

@WebServlet("/HabilitarCategorias")

public class HabilitarCategorias extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    public HabilitarCategorias() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CategoriaController ctrl= new CategoriaController();
		ProductoController ctrlProd= new ProductoController();
		Categoria c= new Categoria();
		
		int id= Integer.parseInt(request.getParameter("id"));
		
		c.setIdCategoria(id);
		c =ctrl.getOne(c);		
		//Date hoy = new Date(System.currentTimeMillis()); 
		//java.sql.Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());

		c.setFecha_hora_baja(null);
		c=ctrl.editCategoria(c);
		
		LinkedList<Producto> prods = new LinkedList<Producto>();
		prods= ctrlProd.listarByCategoria(c);
		for (Producto p: prods) {
			p.setFecha_hora_baja(null);
			p=ctrlProd.actualizarProducto(p);
		}
		
		request.setAttribute("categorias", ctrl.listAllCategorias());
		request.getRequestDispatcher("listarCategorias.jsp").forward(request, response);
	}

}

