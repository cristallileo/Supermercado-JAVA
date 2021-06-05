package servlets;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.LinkedList;
//import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Data.*;
import entidades.*;
import logic.*;

@SuppressWarnings("unused")
@WebServlet("/Inicio")

public class Inicio extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Boolean email_format, pass_format;
		Persona per = new Persona();
		Login ctrl = new Login();
		
			
		String email= request.getParameter("email");
		String pass= request.getParameter("pass");
		
		//VALIDAR FORMATO EMAIL Y PASSWORD
		email_format= emailIsValid(email);
		pass_format= passIsValid(pass);
		
		if(email_format==true && pass_format==true) {
			per.setEmail(email);
			per.setPassword(pass);
			
		//\VALIDAR QUE EXISTA EN LA BDD
			per= ctrl.validate(per);
			
			if (per!=null) {
								
				//VEO SI ES CLIENTE O EMPLEADO
				
				if(per.isCliente()) {
					
					//VEO SI ESTÁ HABILITADO O NO.
					if(per.getFecha_hora_baja()==null) {
					DescuentoController ctrlDcto= new DescuentoController();
					LinkedList<Descuento> descuentos= new LinkedList<Descuento>();
					descuentos=ctrlDcto.listarDescuentosAct();
					request.setAttribute("descuentos", descuentos);
					HttpSession session = request.getSession(true);				
					session.setAttribute("usuario", per);
					request.setAttribute("pedido", null);
					request.getRequestDispatcher("mainpage.jsp").forward(request, response);
					}else {
						request.setAttribute("message_hab", "El usuario no está habilitado para operar.");
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}
				}
				else if(per.isEmpleado()) {
					HttpSession session = request.getSession(true);
					session.setAttribute("usuario", per);
					request.getRequestDispatcher("mainpage-admin.jsp").forward(request, response);
				}
				
			}
			else {
				request.setAttribute("message_def", "Usuario y/o incorrectos. Intente nuevamente.");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		
		else {
			request.setAttribute("message_sec", "La contraseña debe tener entre 8 y 15 caracteres.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}

		private static boolean emailIsValid(String email) {
	      String email_string = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	      return email.matches(email_string);
	   }
	
		private static boolean passIsValid(String pass) {
		      String pass_string = "^([a-zA-Z0-9@*#]{6,15})$"; //Match all alphanumeric character and predefined wild characters. Password must consists of at least 8 characters and not more than 15 characters.
		      return pass.matches(pass_string);
		   }	
}
