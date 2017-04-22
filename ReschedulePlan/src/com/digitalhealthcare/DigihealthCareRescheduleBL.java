
package com.digitalhealthcare;

import java.sql.Date;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.EmailCommunication;
import com.cis.SMSCommunication;
import com.cis.TimeCheck;

/**
 * @author 
 *
 */
public class DigihealthCareRescheduleBL {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigihealthCareRescheduleDAO rescheduleDAO=(DigihealthCareRescheduleDAO)ctx.getBean("reschedulePlanDAO");


	public CISResults reschedulePlan(DigihealthCareRescheduleModel reschedulePlans) {
		// TODO Auto-generated method stub
		 String emailId=CISConstants.ADMINEMAILID;
		 SMSCommunication smsCommunicaiton=new SMSCommunication();
		 EmailCommunication sendMail=new EmailCommunication();
		final Logger logger = Logger.getLogger(DigiHealthCareGetPlanDetailsBL.class);
		
		String userId=reschedulePlans.getUserId();
		Date dateTime=reschedulePlans.getDateTime();
		  TimeCheck time=new TimeCheck();
	      String createDateTime=time.getTimeZone();
	      String sessionId = UUID.randomUUID().toString();
	      String messageId = DigestUtils.sha1Hex(sessionId);
	      String upToNCharacters = messageId.substring(0, Math.min(userId.length(), 5));
	      messageId=upToNCharacters;
	      String emailID= CISConstants.ADMINEMAILID;
	      String phoneNumber=CISConstants.ADMINPHONENUMBER;
		CISResults cisResult = rescheduleDAO.reschedulePlan(messageId,reschedulePlans.getAptId(),reschedulePlans.getPatientId(),reschedulePlans.getUserId(),phoneNumber,emailID,reschedulePlans.getMessageText(),createDateTime,sessionId);
	    //CISResults cisResult = new CISResults();
		
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
