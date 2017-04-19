
package com.digitalhealthcare;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISResults;
import com.cis.EmailCommunication;
import com.cis.SMSCommunication;

/**
 * @author 
 *
 */
public class DigihealthCareSaveMessagesBL {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigihealthCareSaveMessagesDAO saveMessagesDAO=(DigihealthCareSaveMessagesDAO)ctx.getBean("sendMessagesDAO");


	public CISResults sendMessages(String userId,String message) {
		// TODO Auto-generated method stub
		 String emailId="prasad9620@gmail.com";
		 SMSCommunication smsCommunicaiton=new SMSCommunication();
		 EmailCommunication sendMail=new EmailCommunication();
		final Logger logger = Logger.getLogger(DigiHealthCareGetPlanDetailsBL.class);
		CISResults cisResult = saveMessagesDAO.sendMessages(userId,message);
		
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                 "<p>Arcturus Care </b><br />"+
                 
                "<p>"+message+""+
                 
                "<br />\n"+
                "<br />\n"+
                "  Thanks,<br />\n" +
                "<br />\n"+
                " Arcturus Team<br />\n" +

                "  <br />\n" +

                "</body>\n" +
                "</html>";
	String subject = "Arcturus";
	 try {
		 String result = sendMail.sendMailWithAuth("castusinfo.com", "arcturus@castusinfo.com", "arcturus", "25",emailId, msg, subject);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 try {
			cisResult=smsCommunicaiton.sendMessages(userId,message);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
     
	
		logger.info("DigitalHealthCare:send message BL  service" +cisResult );
		return cisResult;
	}
	

}
