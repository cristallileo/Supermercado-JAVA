package logic;

import java.util.Properties;

//import javax.mail.Session;

@SuppressWarnings("unused")
public class Mails {

	public Mails() {
		Properties props = new Properties();
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.port", "587");
		props.setProperty("mail.smtp.auth", "true");
		
		//Session session = Session.getDefaultInstance(props);
	}
	
	
}
