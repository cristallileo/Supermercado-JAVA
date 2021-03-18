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
 * Servlet implementation class DeleteProveedor
 */
@WebServlet("/DeleteProveedor")
public class DeleteProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProveedor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ProveedorController ctrl= new ProveedorController();
		Proveedor p= new Proveedor();
		int id = Integer.parseInt(request.getParameter("id"));
		p.setIdProveedor(id);
		p =ctrl.getById(p);
		ctrl.deleteProveedor(p);
		
		request.setAttribute("proveedores", ctrl.listarProveedores());
		request.getRequestDispatcher("ListProveedores").forward(request, response);
	
		
		
	}

}
