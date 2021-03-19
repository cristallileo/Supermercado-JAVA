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

/**
 * Servlet implementation class EditProveedor
 */
@WebServlet("/EditProveedor")
public class EditProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProveedor() {
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
		// doGet(request, response);
		
		ProveedorController ctrl= new ProveedorController();
		Proveedor prov= new Proveedor();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		prov.setIdProveedor(id);
		prov = ctrl.getById(prov);
		
		String tel= request.getParameter("tel");
		String email= request.getParameter("email");
		String razonSocial= request.getParameter("razonS");
		String baja = request.getParameter("baja");
	    
	   // prov.setIdProveedor(id); 
	    prov.setTelefono(tel);
	    prov.setMail(email);
	    if (baja!=null) {
			Date fecha_baja=Date.valueOf(baja);
			prov.setFechaBaja(fecha_baja);
		    }else {
		    	prov.setFechaBaja(null);
		    }
	    prov.setRazonSocial(razonSocial);
		prov= ctrl.editProveedor(prov);

		
		
		request.setAttribute("proveedor-editado", prov);
		request.setAttribute("proveedores", ctrl.listarProveedores());
		request.getRequestDispatcher("ListProveedores").forward(request, response);
		
	}

}

