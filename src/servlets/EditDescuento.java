
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

import entidades.*;
import logic.*;
/**
 * Servlet implementation class EditDescuento
 */
@WebServlet("/EditDescuento")
public class EditDescuento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDescuento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);  que es esto ??
		
		DescuentoController ctrl= new DescuentoController();
		Descuento dcto= new Descuento();
		
		int id = Integer.parseInt(request.getParameter("id"));
		Double porcentaje= Double.parseDouble(request.getParameter("porc"));
							
		String desde = request.getParameter("fechaIni");
	    Date fecha_desde=Date.valueOf(desde);
	    
		String hasta = request.getParameter("fechaFin");
	    Date fecha_hasta=Date.valueOf(hasta);
				
		dcto.setIdDcto(id);
		dcto.setPorcDcto(porcentaje);
		dcto.setFechaDctoInicio(fecha_desde);
		dcto.setFechaDctoFin(fecha_hasta);
		dcto=ctrl.editDescuento(dcto);
		
		request.setAttribute("descuento-editado", dcto);
		request.setAttribute("descuentos", ctrl.listarDescuentos());
		request.getRequestDispatcher("listarDescuentos.jsp").forward(request, response);
	}
}
