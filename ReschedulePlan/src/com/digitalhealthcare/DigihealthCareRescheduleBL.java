
package com.digitalhealthcare;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
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


	public CISResults reschedulePlan(DigihealthCareRescheduleModel reschedulePlans) throws Exception {
		// TODO Auto-generated method stub
		
		 SMSCommunication smsCommunicaiton=new SMSCommunication();
		 EmailCommunication sendMail=new EmailCommunication();
		 final Logger logger = Logger.getLogger(DigiHealthCareGetPlanDetailsBL.class);
		
		 String userId=reschedulePlans.getUserId();
		 String dateTime=reschedulePlans.getDateTime();
		
		  /* DateFormat sdf = new SimpleDateFormat("EEE MMM dd yyyy HH:hh:ss");
		   Date date = (Date) sdf.parse("Wed Apr 19 2017 12:00:00"); 
		   sdf.setTimeZone(TimeZone.getTimeZone("CST"));
		   System.out.println(sdf.format(date));
		*/
		
		
		  TimeCheck time=new TimeCheck();
	      String createDateTime=time.getTimeZone();
	      String sessionId = UUID.randomUUID().toString();
	      String messageId=DigestUtils.sha1Hex(sessionId);
          String upToNCharacters = messageId.substring(0, Math.min(messageId.length(), 6));
          messageId=upToNCharacters;
	      String emailID= CISConstants.ADMINEMAILID;
	      String phoneNumber=CISConstants.ADMINPHONENUMBER;
	      String type=CISConstants.SENT;
	      String messageText=reschedulePlans.getMessageText()+":"+dateTime;
		  CISResults cisResult = rescheduleDAO.reschedulePlan(messageId,reschedulePlans.getAptId(),reschedulePlans.getPatientId(),reschedulePlans.getUserId(),phoneNumber,emailID,messageText,createDateTime,sessionId,type);
		
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
