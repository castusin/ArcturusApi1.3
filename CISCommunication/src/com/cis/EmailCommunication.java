package com.cis;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailCommunication {
	
	public String sendMailWithAuth(String host, String user, String password,
	        String port, String to, String body, String subject) throws Exception{
	    // TODO Auto-generated method stub
	    
	    
	    Properties props = System.getProperties();

	      props.put("mail.smtp.user", user);
	      props.put("mail.smtp.password", password);
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", port);
	      props.put("mail.debug", "true");
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "false");
	      props.put("mail.smtp.EnableSSL.enable", "false");

	      Session session = Session.getInstance(props, null);
	      session.setDebug(true);

	      MimeMessage message = new MimeMessage(session);
	      message.setFrom(new InternetAddress(user));

	      // To get the array of addresses    
	      message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));


	      message.setSubject(subject);
	    
	      message.setContent(body, "text/html");

	  
	      Transport transport = session.getTransport("smtp");
	      try {
	          transport.connect(host, user, password);
	          transport.sendMessage(message, message.getAllRecipients());
	          Transport.send(message);
	          transport.close();
	         
	          //success = "success";
	      } finally {
//	          transport.close();
	      }
	      return "0";
	    
	    
	}
	

}

