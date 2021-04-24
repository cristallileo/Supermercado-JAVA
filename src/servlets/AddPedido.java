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
		//estado se setea por defecto en Nuevo
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
			d=d_max;
			p.setId_dcto(d.getIdDcto());
		}else if (dctos.size()==1) {
			for(Descuento des2: dctos) {
				d=des2;
			}
			p.setId_dcto(d.getIdDcto());
		}else if (dctos.size()==0) {
			//p.setId_dcto(null);
			// SI NO HAY NINGUN DCTO QUEDA EN NULL (LA BDD LO PONE X DEFECTO EN NULL)
		}
		
	}

}
