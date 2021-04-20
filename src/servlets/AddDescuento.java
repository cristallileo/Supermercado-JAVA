package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Date;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entidades.Descuento;
import logic.DescuentoController;
import logic.*;

@SuppressWarnings("unused")
@WebServlet("/AddDescuento")

public class AddDescuento extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public AddDescuento() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Descuento d = new Descuento();
		DescuentoController ctrl = new DescuentoController();
		//MyHelper h= new MyHelper();
		
		String porc= request.getParameter("porc");
		Double porcen= Double.parseDouble(porc);
			
		String desde = request.getParameter("desde");
	    Date fecha_desde=Date.valueOf(desde);
	    
		String hasta = request.getParameter("hasta");
	    Date fecha_hasta=Date.valueOf(hasta);
	   
		/*try {
			h.verificarFechas(fecha_desde, fecha_hasta);
		}
		catch (CustomException e) {
			//ce.printStackTrace();
			request.setAttribute("message_fechas", e.getMessage());
			request.getRequestDispatcher("crearDcto.jsp").forward(request, response); 
		}
		*/
	    if (fecha_hasta.after(fecha_desde)) {
	    	
	    	d.setPorcDcto(porcen);
	    	d.setFechaDctoInicio(fecha_desde);
	    	d.setFechaDctoFin(fecha_hasta);
	    	d= ctrl.add(d);	
		    
			request.setAttribute("nuevoDesc", d);
			request.getRequestDispatcher("ListDescuentos").forward(request, response);
	    }
	    else
	    {
	    	request.setAttribute("message_wrong_date", "La fecha de finalización de un descuento no puede ser menor o igual a su fecha de inicio");
			request.getRequestDispatcher("crearDcto.jsp").forward(request, response);
	    }

		

	
		
	}

}
