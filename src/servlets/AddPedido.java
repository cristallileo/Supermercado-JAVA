package servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
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
 * Servlet implementation class AddPedido
 */
@WebServlet("/AddPedido")
public class AddPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pedido p = new Pedido();
		PedidoController ctrl= new PedidoController();
		
		//Cargo los datos iniciales del pedido
		java.sql.Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());
		p.setFechaPedido(timeNow);
		p.setEstado("Nuevo");
		//seteo usuario que crea el pedido
		Persona per= new Persona();
		per= (Persona)request.getSession(true).getAttribute("usuario");
		p.setId_persona(per.getIdPersona());
		p.setPrecioTotal(0.00);
		
		//ASIGNO UN DESCUENTO SI ES QUE HAY ALGUNO ACTIVO.
		LinkedList<Descuento> dctos= new LinkedList<Descuento>();
		DescuentoController ctrlDesc= new DescuentoController();
		Descuento d= new Descuento();
		Descuento d_max= new Descuento();
		dctos= ctrlDesc.listarDescuentosAct();
		//BUSCO EL MAYOR DESCUENTO: SI HAY MAS DE UN DESCUENTO ACTIVO EN UN DIA SE TOMA EL MAYOR PARA EL PEDIDO.
		if(dctos.size()>1) {
			Double valor=(double) 0;
			for (Descuento des: dctos) {
				if(des.getPorcDcto()>valor) {
					d_max=des;
					valor=des.getPorcDcto();
				}
			}
			d=d_max; //tomo el dcto activo con mayor porcentaje de dcto
			p.setId_dcto(d.getIdDcto());
		}else if (dctos.size()==1) {
			for(Descuento des2: dctos) {
				d=des2; //tomo el unico que hay activo
			}
			p.setId_dcto(d.getIdDcto());
		}else if (dctos.size()==0) {
			//p.setId_dcto();
			// SI NO HAY NINGUN DCTO QUEDA EN NULL (LA BDD LO PONE X DEFECTO EN NULL)
		}
		
		ctrl.add(p);
		
		HttpSession session = request.getSession(true);				
		session.setAttribute("pedido", p);
		
		//Parametros que paso a productos.jsp
		ProductoController ctrlProd= new ProductoController();
		CategoriaController ctrlCat= new CategoriaController();
		LinkedList<Producto> productos= new LinkedList<Producto>();
		LinkedList<Categoria> categorias= new LinkedList<Categoria>();
		productos=ctrlProd.listAllProductos();
		categorias= ctrlCat.listCategoriasActivas();
		categorias=ctrlCat.listCategoriasNoVacias(categorias);
		request.setAttribute("categorias", categorias);
		LinkedList<Producto> prods_activos= new LinkedList<Producto>();
			for (Producto prod: productos) {
				if (prod.getFecha_hora_baja()==null) {
					prods_activos.add(prod);
				}
			}	
		request.setAttribute("productos", prods_activos);
		request.setAttribute("descrip", null);
		//request.setAttribute("pedido", p);
		request.getRequestDispatcher("productos.jsp").forward(request, response);
		
	}

}
