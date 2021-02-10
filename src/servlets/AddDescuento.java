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

/**
 * Servlet implementation class AddDescuento
 */
@SuppressWarnings("unused")
@WebServlet("/AddDescuento")
public class AddDescuento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDescuento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		Descuento d = new Descuento();
		Descuento descuento= new Descuento();
		//LinkedList<Descuento> descuentos = new LinkedList<Descuento>();
		DescuentoController ctrl = new DescuentoController();
		
		String porc= request.getParameter("porc");
		Double porcen= Double.parseDouble(porc);
		
		String desde = request.getParameter("desde");
	    Date fecha_desde=Date.valueOf(desde);
	    
		String hasta = request.getParameter("hasta");
	    Date fecha_hasta=Date.valueOf(hasta);
		
		d.setPorcDcto(porcen);
		d.setFechaDctoInicio(fecha_desde);
		d.setFechaDctoFin(fecha_hasta);
		descuento= ctrl.add(d);
		//d.setFechaDctoInicio(fd);
		
		//descuentos= ctrl.listarDescuentos();

		request.setAttribute("nuevoDesc", descuento);
		//request.setAttribute("descuentos", descuentos);
		request.getRequestDispatcher("ListDescuentos").forward(request, response);
	}

}
