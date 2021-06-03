package servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.*;
import logic.*;

/**
 * Servlet implementation class DeshabilitarCliente
 */
@WebServlet("/DeshabilitarCliente")
public class DeshabilitarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeshabilitarCliente() {
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
		
		PersonaController ctrl = new PersonaController();
		Persona p = new Persona();
		
		int id= Integer.parseInt(request.getParameter("id"));
		p.setIdPersona(id);
		p=ctrl.getById(p);
		
		java.sql.Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());
		p.setFecha_hora_baja(timeNow);
		p=ctrl.deshabilitarCliente(p);
		
		request.setAttribute("descrip", null);
		request.setAttribute("listado", ctrl.listarClientes());
		request.getRequestDispatcher("listarClientes.jsp").forward(request, response);
	}

}
