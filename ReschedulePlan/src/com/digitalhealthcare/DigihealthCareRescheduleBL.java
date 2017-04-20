
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
public class DigihealthCareRescheduleBL {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigihealthCareRescheduleDAO rescheduleDAO=(DigihealthCareRescheduleDAO)ctx.getBean("reschedulePlanDAO");


	public CISResults reschedulePlan(String userId,String dateTime) {
		// TODO Auto-generated method stub
		 String emailId=CISConstants.ADMINEMAILID;
		 SMSCommunication smsCommunicaiton=new SMSCommunication();
		 EmailCommunication sendMail=new EmailCommunication();
		final Logger logger = Logger.getLogger(DigiHealthCareGetPlanDetailsBL.class);
		//CISResults cisResult = rescheduleDAO.reschedulePlan(userId,dateTime);
		CISResults cisResult = new CISResults();
		
		try {
			cisResult=smsCommunicaiton.sendMessagesReschedule(userId,dateTime);
			} catch (Throwable e) {
				
				e.printStackTrace();
				cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
				cisResult.setErrorMessage(CISConstants.SMS_FAILED);
			} 
		
		if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
	     {
		  cisResult=sendMail.sendMailDateTime(dateTime);
	     }
		
		logger.info("DigitalHealthCare:reschedulePlan BL  service" +cisResult );
		return cisResult;
	}
	

}
