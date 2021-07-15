package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Date;
import java.util.Calendar;
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
				
		if(porcen>=1) {
			request.setAttribute("message_porc", "El descuento debe ser un valor entre 0 y 1.");
			request.getRequestDispatcher("crearDcto.jsp").forward(request, response);
		}else {
			
		String desde = request.getParameter("desde");
	    Date fecha_desde=Date.valueOf(desde);
	    
		String hasta = request.getParameter("hasta");
	    Date fecha_hasta=Date.valueOf(hasta);
	   
		java.sql.Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());
		/*try {
			h.verificarFechas(fecha_desde, fecha_hasta);
		}
		catch (CustomException e) {
			//ce.printStackTrace();
			request.setAttribute("message_fechas", e.getMessage());
			request.getRequestDispatcher("crearDcto.jsp").forward(request, response); 
		}
		*/
		if (fecha_hasta.after(timeNow)) {
			
		
			if (fecha_hasta.after(fecha_desde)) {
	    	
				d.setPorcDcto(porcen);
				d.setFechaDctoInicio(fecha_desde);
				d.setFechaDctoFin(fecha_hasta);
				d= ctrl.add(d);	
		    
				request.setAttribute("nuevoDesc", d);
				request.getRequestDispatcher("ListDescuentos").forward(request, response);
			}
			else {
				request.setAttribute("message_wrong_date1", "La fecha de finalización de un descuento no puede ser menor o igual a su fecha de inicio");
				request.getRequestDispatcher("crearDcto.jsp").forward(request, response);
			}
		}
		else if (fecha_hasta.equals(timeNow)) {
			
			if (fecha_hasta.after(fecha_desde)) {
		    	
				d.setPorcDcto(porcen);
				d.setFechaDctoInicio(fecha_desde);
				d.setFechaDctoFin(fecha_hasta);
				d= ctrl.add(d);	
		    
				request.setAttribute("nuevoDesc", d);
				request.getRequestDispatcher("ListDescuentos").forward(request, response);
			}
			else {
				request.setAttribute("message_wrong_date1", "La fecha de finalización debe ser posterior a su fecha de inicio");
				request.getRequestDispatcher("crearDcto.jsp").forward(request, response);
			}
							
		}
		else {
			request.setAttribute("message_wrong_date2", "La fecha de fin no puede ser anterior al dia de hoy");
			request.getRequestDispatcher("crearDcto.jsp").forward(request, response);
		}
		/* Lo intente hacer con un or dentro del primer if pero por alguna razon no me dejaba (The target type of this expression must be a functional  error)
		no me quedo otra que anidar if y dividir la condicion, manejar fechas con java.sql.Date es bastante problematico */
	}}
}
