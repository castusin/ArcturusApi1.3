package com.cis;

import java.sql.Date;
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
	    String result="";
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
	          result=CISConstants.RESPONSE_SUCCESS;
	      } finally {
//	          transport.close();
	      }
	      return result;
	    
	    
	}

	public CISResults sendMail(String PemailId,String pfname, String plname, String apptWith,
			String serviceType, String startTime, String patientId) {


		CISResults cisResult = new CISResults();
		String emailId=CISConstants.ADMINEMAILID;
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
               /* "<p>Dear "+""+pfname+""+plname+", </b><br />"+*/
                "<p>Dear  "+" "+ pfname +" "+ plname +"</b><br />"+
                "<p>We received your request for cancellation of appointment.</b><br />"+
                "<p>Service Type :"+" "+serviceType+"</b><br />"+
                
				"<p>Appointment Date and Time :"+" "+startTime+"</b><br />"+
				 "<p>Staff Name : "+apptWith+"</b><br /><br /><br />"+
				
              /*  "<p>http://arcturus.castusinfo.com/HTML/app/home.html#/event?id="+patientId+"&mode=outside_domain"+
              */   
                "<br />\n"+
                "<br />\n"+
                "  Thanks,<br />\n" +
                "<br />\n"+
                " Arcturus Team<br />\n" +

                "  <br />\n" +

                "</body>\n" +
                "</html>";
	String subject = CISConstants.CANCELSUBJECT;
	 try {
		 String result = sendMailWithAuth(CISConstants.PRODEMAILHOST,CISConstants.PRODEMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,PemailId, msg, subject);
	  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cisResult;
	}

	public CISResults sendMailDateTime(String PemailId,String dateTime, String startTime,String pfname,
			String plname, String apptWith, String serviceType, String patientId) {


		CISResults cisResult = new CISResults();
		String emailId=CISConstants.ADMINEMAILID;
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "<p>Dear  "+" "+ pfname +" "+ plname +"</b><br />"+
                 "<p>We received your request for reschedule appointment. </b><br />"+
                
                
 				"<p>Service Type :"+" "+serviceType+"</b><br />"+
 
				
				 "<p>Staff Name :"+" "+apptWith+"</b><br /><br /><br />"+
				 "<p>Appointment Date and Time :"+" "+startTime+"</b><br />"+
				 "<p>New appointment date and time :"+" "+dateTime+"</b><br />"+
				 "<p>Please note this is not final conformation for the change in the appointment. We will work on this request and send a final confirmation.  </b><br />"+
               /* "<p>http://arcturus.castusinfo.com/HTML/app/home.html#/event?id="+patientId+"&mode=outside_domain"+
  */
                "<br />\n"+
                "<br />\n"+
                "  Thanks,<br />\n" +
                "<br />\n"+
                " Arcturus Team<br />\n" +

                "  <br />\n" +

                "</body>\n" +
                "</html>";
	String subject = CISConstants.SUBJECT;
	 try {
		 String result = sendMailWithAuth(CISConstants.PRODEMAILHOST,CISConstants.PRODEMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,PemailId, msg, subject);
	  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cisResult;
	}

	public CISResults sendMailDateTimeAdmin(String pemailId, String dateTime,
			String startTime, String pfname, String plname, String apptWith,
			String serviceType, String patientId) {


		CISResults cisResult = new CISResults();
		String emailId=CISConstants.ADMINEMAILID;
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                 "<p>Request for reschedule appointment. </b><br />"+
                 "<p>Requested by : "+" "+ pfname +" "+ plname +"</b><br />"+
                
                
 				"<p>Service Type :"+" "+serviceType+"</b><br />"+
 
				
				 "<p>Current Staff Name :"+" "+apptWith+"</b><br /><br /><br />"+
				 "<p>Current Appointment Date and Time :"+" "+startTime+"</b><br />"+
				 "<p>New appointment date and time :"+" "+dateTime+"</b><br />"+
				 "<p>Click here to change appointment in Arcturus Admin Portal </b><br />"+
               // "<p>http://arcturus.castusinfo.com/HTML/app/home.html#/event?id="+patientId+"&mode=outside_domain"+
               "<p>http://arcturus.mathgator.com/HTML/app/home.html#/event?id="+patientId+"&mode=outside_domain"+"&adminId=101"+
               
                "<br />\n"+
                "<br />\n"+
                "  Thanks,<br />\n" +
                "<br />\n"+
                " Arcturus Team<br />\n" +

                "  <br />\n" +

                "</body>\n" +
                "</html>";
	String subject = CISConstants.SUBJECT;
	 try {
		 String result = sendMailWithAuth(CISConstants.PRODEMAILHOST,CISConstants.PRODEMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,emailId, msg, subject);
	  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cisResult;
	}

	public CISResults sendMailSaveMsg(String message, String patientId) {
		// TODO Auto-generated method stub


		CISResults cisResult = new CISResults();
		String emailId=CISConstants.ADMINEMAILID;
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                 "<p>Arcturus Care </b><br />"+
                 
                "<p>"+message+" "+
                 
                "<br />\n"+
                "<br />\n"+
                "  Thanks,<br />\n" +
                "<br />\n"+
                " Arcturus Team<br />\n" +

                "  <br />\n" +

                "</body>\n" +
                "</html>";
	String subject = CISConstants.SUBJECT;
	 try {
		 String result = sendMailWithAuth(CISConstants.PRODEMAILHOST,CISConstants.PRODEMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,emailId, msg, subject);
	  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cisResult;
	}

	public CISResults sendMailAdmin(String pfname, String plname,
			String apptWith, String serviceType, String startTime,
			String patientId) {


		CISResults cisResult = new CISResults();
		String emailId=CISConstants.ADMINEMAILID;
		//String adminId="101";
				
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                 "<p>Cancel appointment </b><br />"+
                 
                "<p>Requested by :"+" "+ pfname +" "+ plname +"</b><br />"+
                "<p>Service Type :"+" "+serviceType+"</b><br />"+
                
				"<p>Appointment Date and Time :"+" "+startTime+"</b><br />"+
				 "<p>Staff Name :"+" "+apptWith+"</b><br /><br /><br />"+
				 "<p>Click here to change appointment in Arcturus Admin Portal </b><br />"+
               // "<p>http://arcturus.castusinfo.com/HTML/app/home.html#/event?id="+patientId+"&mode=outside_domain"+
               "<p>http://arcturus.mathgator.com/HTML/app/home.html#/event?id="+patientId+"&mode=outside_domain"+"&adminId=101"+
               
                "<br />\n"+
                "<br />\n"+
                "  Thanks,<br />\n" +
                "<br />\n"+
                " Arcturus Team<br />\n" +

                "  <br />\n" +

                "</body>\n" +
                "</html>";
	String subject = CISConstants.CANCELSUBJECT;
	 try {
		 String result = sendMailWithAuth(CISConstants.PRODEMAILHOST,CISConstants.PRODEMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,emailId, msg, subject);
	  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cisResult;
	}
	
	
	
	
}

