package servlets;

import java.io.IOException;
import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.*;

/**
 * Servlet implementation class EnviarCorreo
 */
@WebServlet("/EnviarCorreo")
public class EnviarCorreo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnviarCorreo() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		try{
		
		//Persona per= new Persona();
		//per= (Persona)request.getSession(true).getAttribute("usuario");
			
		String asunto= request.getParameter("asunto");
		String mensaje=request.getParameter("mensaje");
			
		Properties props = new Properties();
		props.setProperty("mail smtp host", "smtp.gmail.com");
		//props.setProperty("mail.smtp.ssl.enable", "true");
		props.setProperty("mail smtp port", "25");
		props.setProperty("mail.smtp.auth", "true");
		
		System.out.println("1");
		Session session = Session.getDefaultInstance(props);
		
		String mail_emisor = "@gmail.com";
		String pass_emisor="";
		
		String mail_receptor= "@gmail.com";
		
		
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(mail_emisor));
		
		System.out.println("2");
		
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(mail_receptor));
		message.setSubject(asunto);
		message.setText(mensaje);
		
		
		System.out.println("3");
		
		Transport t = session.getTransport("smtp");
		t.connect(mail_emisor,pass_emisor);
		//t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
		t.close();
		
		System.out.println("4");
		
		
		
		} catch(AddressException ex) {
			System.out.println("error1");
		}catch(MessagingException ex) {
			System.out.println("error2");
			ex.printStackTrace();
	
		}
		request.getRequestDispatcher("contacto.jsp").forward(request, response);
	

}
}
