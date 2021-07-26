package servlets;

import java.io.IOException;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.Descuento;
import entidades.Pedido;
import entidades.Persona;
import logic.DescuentoController;

@WebServlet("/ListDescuentos")

public class ListDescuentos extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ListDescuentos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DescuentoController ctrl= new DescuentoController();
		LinkedList<Descuento> descuentos= new LinkedList<Descuento>();
		LinkedList<Descuento> descuentos2= new LinkedList<Descuento>();
		//Veo a donde lo direcciono:
				Persona per= new Persona();
				per= (Persona)request.getSession(true).getAttribute("usuario");
				if(per==null){
					request.getRequestDispatcher("error-sesion.jsp").forward(request, response);
				}else if(per.isCliente()==true) {
					descuentos=ctrl.listarDescuentosAct();
					for(Descuento d: descuentos) {
						if(d.getFecha_hora_baja()==null) {
							descuentos2.add(d);
						}
					}
					request.setAttribute("descuentos", descuentos2);
					Pedido p = new Pedido();
					p= (Pedido)request.getSession(true).getAttribute("pedido");
					request.setAttribute("pedido", p);
					request.getRequestDispatcher("mainpage.jsp").forward(request, response); 
				}else {
					request.setAttribute("descuentos", ctrl.listarDescuentosHabilitados());
					 request.getRequestDispatcher("listarDescuentos.jsp").forward(request, response);
				}
		

	}

}
