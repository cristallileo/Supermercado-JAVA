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

import entidades.Proveedor;
import logic.ProveedorController;

/**
 * Servlet implementation class AddProveedor
 */
@WebServlet("/AddProveedor")
public class AddProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProveedor() {
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
	 *@see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		Proveedor prov = new Proveedor();
		ProveedorController ctrl = new ProveedorController();
		
		// idProveedor, telefono, email, razonSocial, fechaBaja
		
		String tel= request.getParameter("tel");
		String email= request.getParameter("email");
		String razonSocial= request.getParameter("razonSocial");
		String baja = request.getParameter("baja");
	    Date fecha_baja=Date.valueOf(baja);
	    
	    prov.setTelefono(tel);
	    prov.setMail(email);
	    prov.setRazonSocial(razonSocial);
	    prov.setFechaBaja(fecha_baja);
	    prov= ctrl.add(prov);

		request.setAttribute("nuevoProv", prov);
		request.getRequestDispatcher("ListProveedores").forward(request, response);
	}

}
