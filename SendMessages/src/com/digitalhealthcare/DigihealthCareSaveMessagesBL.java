
package com.digitalhealthcare;

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
public class DigihealthCareSaveMessagesBL {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigihealthCareSaveMessagesDAO saveMessagesDAO=(DigihealthCareSaveMessagesDAO)ctx.getBean("sendMessagesDAO");


	public CISResults sendMessages(DigihealthCareSaveMessagesModel saveMessages) {
		
		  SMSCommunication smsCommunicaiton=new SMSCommunication();
		  EmailCommunication sendMail=new EmailCommunication();
		  final Logger logger = Logger.getLogger(DigiHealthCareGetPlanDetailsBL.class);
		  TimeCheck time=new TimeCheck();
	      String createDate=time.getTimeZone();
	      String message=saveMessages.getMessageText();
	      String userId=saveMessages.getUserId();
	      String sessionId = UUID.randomUUID().toString();
	      String messageId=DigestUtils.sha1Hex(sessionId);
          String upToNCharacters = messageId.substring(0, Math.min(messageId.length(), 6));
          messageId=upToNCharacters;
	      String emailId= CISConstants.ADMINEMAILID;
	      String phoneNumber=CISConstants.ADMINPHONENUMBER;
	      String type=CISConstants.SENT;
	      String patientId=saveMessages.getPatientId();
	      String messageCategory=CISConstants.PATIENT_MESSAGE;
		  CISResults cisResult = saveMessagesDAO.sendMessages(messageId,saveMessages.getAptId(),saveMessages.getPatientId(),saveMessages.getUserId(),phoneNumber,emailId,saveMessages.getMessageText(),createDate,sessionId,type,messageCategory);
		  try {
			cisResult=smsCommunicaiton.sendMessages(userId,message);
			} catch (Throwable e) {
				
				e.printStackTrace();
				cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
				cisResult.setErrorMessage(CISConstants.SMS_FAILED);
			} 
		
		if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
	     {
		  cisResult=sendMail.sendMailSaveMsg(message,patientId);
	     }
		logger.info("DigitalHealthCare:send message BL  service" +cisResult );
		return cisResult;
	}
	

}
