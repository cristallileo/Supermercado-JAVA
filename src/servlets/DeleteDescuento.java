package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.*;
import logic.*;


/**
 * Servlet implementation class DeleteDescuento
 */
@WebServlet("/DeleteDescuento")
public class DeleteDescuento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDescuento() {
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

		DescuentoController ctrl= new DescuentoController();
		Descuento d= new Descuento();
		//response.getWriter().append("Served at: ").append(id);
		int id = Integer.parseInt(request.getParameter("id"));
		d.setIdDcto(id);
		d =ctrl.getById(d);
		ctrl.deleteDescuento(d);
		
		request.setAttribute("descuentos", ctrl.listarDescuentos());
		request.getRequestDispatcher("ListDescuentos").forward(request, response);
	
	}

}
