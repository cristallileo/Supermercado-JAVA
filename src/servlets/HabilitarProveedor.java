package servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Proveedor;
import logic.ProveedorController;

/**
 * Servlet implementation class HabilitarProveedor
 */
@WebServlet("/HabilitarProveedor")
public class HabilitarProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HabilitarProveedor() {
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
		//doGet(request, response);
		ProveedorController ctrl= new ProveedorController();
		Proveedor prov= new Proveedor();
		int id= Integer.parseInt(request.getParameter("idProv"));
		prov.setIdProveedor(id);
		prov =ctrl.getById(prov);
		
		//Date hoy = new Date(System.currentTimeMillis()); 
		//java.sql.Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());
		prov.setFechaBaja(null);
		prov=ctrl.editProveedor(prov);
		request.setAttribute("proveedorHabilitado", prov);
		request.setAttribute("proveedores", ctrl.listarProveedores());
		request.getRequestDispatcher("listarProveedores.jsp").forward(request, response);
		
		
	}

}
