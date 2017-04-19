
package com.digitalhealthcare;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
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
		
		 SMSCommunication smsCommunicaiton=new SMSCommunication();
		 EmailCommunication sendMail=new EmailCommunication();
		final Logger logger = Logger.getLogger(DigiHealthCareGetPlanDetailsBL.class);
		//CISResults cisResult = saveMessagesDAO.sendMessages(userId,message);
		CISResults cisResult = new CISResults();
		try {
			cisResult=smsCommunicaiton.sendMessages(userId,message);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
				cisResult.setErrorMessage(CISConstants.SMS_FAILED);
			} 
		
		if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
	     {
		  cisResult=sendMail.sendMail(message);
	     }
		logger.info("DigitalHealthCare:send message BL  service" +cisResult );
		return cisResult;
	}
	

}
