
package servlets;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.*;
import logic.*;

@WebServlet("/EditDescuento")

public class EditDescuento extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public EditDescuento() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DescuentoController ctrl= new DescuentoController();
		Descuento dcto= new Descuento();
		MyHelper h= new MyHelper();
		request.setAttribute("message_fechas", null);
		
		int id = Integer.parseInt(request.getParameter("id"));
		dcto.setIdDcto(id);
		dcto=ctrl.getById(dcto);
		Double porcentaje= Double.parseDouble(request.getParameter("porc"));
		
		if(porcentaje>=1) {
			request.setAttribute("message_porc", "El descuento debe ser un valor entre 0 y 1.");
			request.setAttribute("descuentoEditar", dcto);
			request.getRequestDispatcher("editarDescuento.jsp").forward(request, response);
		}else {
							
		String desde = request.getParameter("fechaIni");
	    Date fecha_desde=Date.valueOf(desde);
	    
		String hasta = request.getParameter("fechaFin");
	    Date fecha_hasta=Date.valueOf(hasta);
				
		try {
			h.verificarFechas(fecha_desde, fecha_hasta);
		}
		catch (CustomException e) {
			//ce.printStackTrace();
			request.setAttribute("message_fechas", e.getMessage());
			request.getRequestDispatcher("BuscarDescuento?id="+ id).forward(request, response);
		}
	    
		dcto.setIdDcto(id);
		dcto.setPorcDcto(porcentaje);
		dcto.setFechaDctoInicio(fecha_desde);
		dcto.setFechaDctoFin(fecha_hasta);
		dcto=ctrl.editDescuento(dcto);
		
		request.setAttribute("descuento-editado", dcto);
		request.setAttribute("descuentos", ctrl.listarDescuentos());
		request.getRequestDispatcher("listarDescuentos.jsp").forward(request, response);
	}
}}
