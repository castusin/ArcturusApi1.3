
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
public class DigihealthCareCancelRescheduleplanBL {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigihealthCareCancelRescheduleplanDAO cancelRescheduleplanDAO=(DigihealthCareCancelRescheduleplanDAO)ctx.getBean("CancelreschedulePlanDAO");


	public CISResults cancelSchedulePlan(DigihealthCareCancelRescheduleplanModel cancelSchedulePlan) {
		// TODO Auto-generated method stub
		
		 SMSCommunication smsCommunicaiton=new SMSCommunication();
		 EmailCommunication sendMail=new EmailCommunication();
		final Logger logger = Logger.getLogger(DigiHealthCareGetPlanDetailsBL.class);
		
		  String userId=cancelSchedulePlan.getUserId();
		//  Date dateTime=cancelSchedulePlan.getDateTime();
		  String message=CISConstants.CANCEL;
	      TimeCheck time=new TimeCheck();
	      String createDateTime=time.getTimeZone();
	      String sessionId = UUID.randomUUID().toString();
	      String messageId=DigestUtils.sha1Hex(sessionId);
          String upToNCharacters = messageId.substring(0, Math.min(messageId.length(), 6));
          messageId=upToNCharacters;
	      String emailID= CISConstants.ADMINEMAILID;
	      String phoneNumber=CISConstants.ADMINPHONENUMBER;
		  CISResults cisResult = cancelRescheduleplanDAO.cancelSchedulePlan(messageId,cancelSchedulePlan.getAptId(),cancelSchedulePlan.getPatientId(),cancelSchedulePlan.getUserId(),phoneNumber,emailID,message,createDateTime,sessionId);
		
		try {
			cisResult=smsCommunicaiton.sendMessages(userId,message);
			} catch (Throwable e) {
				
				e.printStackTrace();
				cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
				cisResult.setErrorMessage(CISConstants.SMS_FAILED);
			} 
		
		if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
	     {
		  cisResult=sendMail.sendMail(message);
	     }
		
		logger.info("DigitalHealthCare:reschedulePlan BL  service" +cisResult );
		return cisResult;
	}
	

}
