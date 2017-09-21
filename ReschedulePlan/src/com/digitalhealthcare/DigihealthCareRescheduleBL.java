
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
		
		  SMSCommunication smsCommunicaiton=new SMSCommunication();
		  EmailCommunication sendMail=new EmailCommunication();
		  final Logger logger = Logger.getLogger(DigiHealthCareGetPlanDetailsBL.class);
		
		  String userId=reschedulePlans.getUserId();
		  String dateTime=reschedulePlans.getDateTime();
		
		  TimeCheck time=new TimeCheck();
	      String createDateTime=time.getTimeZone();
	      String sessionId = UUID.randomUUID().toString();
	      String messageId=DigestUtils.sha1Hex(sessionId);
          String upToNCharacters = messageId.substring(0, Math.min(messageId.length(), 6));
          messageId=upToNCharacters;
	      String emailID= CISConstants.ADMINEMAILID;
	      String phoneNumber=CISConstants.ADMINPHONENUMBER;
	      String type=CISConstants.SENT;
	      String messageText=reschedulePlans.getMessageText();
	      String patientId=reschedulePlans.getPatientId();
	      String aptId=reschedulePlans.getAptId();
	      String messageCategory=CISConstants.RESCHEDULE_REQUEST;
		  CISResults cisResult = rescheduleDAO.reschedulePlan(messageId,reschedulePlans.getAptId(),reschedulePlans.getPatientId(),reschedulePlans.getUserId(),phoneNumber,emailID,messageText,createDateTime,sessionId,type,messageCategory);
		
		  
		  cisResult = rescheduleDAO.getpatientDetails(aptId);
			 
		  GetPatientDetailsModel  patientfname=(GetPatientDetailsModel)cisResult.getResultObject();
          String Pfname=patientfname.getPatientFname();
          GetPatientDetailsModel  patientlname=(GetPatientDetailsModel)cisResult.getResultObject();
          String Plname=patientlname.getPatientLname();
          GetPatientDetailsModel  aptwith=(GetPatientDetailsModel)cisResult.getResultObject();
          String apptWith=aptwith.getAptWith();
          GetPatientDetailsModel  servicetype=(GetPatientDetailsModel)cisResult.getResultObject();
          String serviceType=servicetype.getServicetype();
          GetPatientDetailsModel  starttime=(GetPatientDetailsModel)cisResult.getResultObject();
          String startTime=starttime.getStartTime();
		  
          GetPatientDetailsModel  emailid=(GetPatientDetailsModel)cisResult.getResultObject();
          String pemailId=emailid.getEmailid();
		  
		  // sending sms
		  try {
			cisResult=smsCommunicaiton.sendMessagesReschedule(userId,dateTime);
			} catch (Throwable e) {
				
				e.printStackTrace();
				cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
				cisResult.setErrorMessage(CISConstants.SMS_FAILED);
			} 
		// sending mail
		if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
	     {
		  cisResult=sendMail.sendMailDateTime(pemailId,dateTime,startTime,Pfname,Plname,apptWith,serviceType,patientId);
		  cisResult=sendMail.sendMailDateTimeAdmin(pemailId,dateTime,startTime,Pfname,Plname,apptWith,serviceType,patientId);
		    
	     }
		
		logger.info("DigitalHealthCare:reschedulePlan BL  service" +cisResult );
		return cisResult;
	}
	

}
