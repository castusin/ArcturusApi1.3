
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
public class DigihealthCareCancelRescheduleplanBL {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigihealthCareCancelRescheduleplanDAO cancelRescheduleplanDAO=(DigihealthCareCancelRescheduleplanDAO)ctx.getBean("CancelreschedulePlanDAO");


	public CISResults cancelSchedulePlan(DigihealthCareCancelRescheduleplanModel cancelSchedulePlan) {
		
		 SMSCommunication smsCommunicaiton=new SMSCommunication();
		 EmailCommunication sendMail=new EmailCommunication();
		 final Logger logger = Logger.getLogger(DigiHealthCareGetPlanDetailsBL.class);
		
		  String userId=cancelSchedulePlan.getUserId();
		//  Date dateTime=cancelSchedulePlan.getDateTime();
		  CISResults cisResult =new CISResults();
		 // String s1=
		  String message=CISConstants.CANCEL;
	      TimeCheck time=new TimeCheck();
	      String createDateTime=time.getTimeZone();
	      String sessionId = UUID.randomUUID().toString();
	      String messageId=DigestUtils.sha1Hex(sessionId);
          String upToNCharacters = messageId.substring(0, Math.min(messageId.length(), 6));
          messageId=upToNCharacters;
	      String emailID= CISConstants.ADMINEMAILID;
	      String phoneNumber=CISConstants.ADMINPHONENUMBER;
	      String type=CISConstants.SENT;
	      String patientId=cancelSchedulePlan.getPatientId();
	      String aptId=cancelSchedulePlan.getAptId();
	      String messageCategory=CISConstants.CANCEL_APT_REQUEST;
	      
	      
	      cisResult = cancelRescheduleplanDAO.getpatientDetails(aptId);
			 
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
	      
         
	      
		  String msg="<p>Cancel Request<p/>"+
		    		 "<p>Staff Name : "+apptWith+"<p/>"+
		    		 "<p>Appointment Time : "+startTime+"<p/>"+
		    		 "<p>Service Type : "+serviceType+"<p/>"
		    		 ;
		  
		  String msgs="Cancel Request"+
		    		 "Staff Name : "+apptWith+""+
		    		 "Appointment Time : "+startTime+""+
		    		 "Service Type : "+serviceType+""
		    		 ;
		  			
		  
		  
		  
		   cisResult = cancelRescheduleplanDAO.cancelSchedulePlan(messageId,cancelSchedulePlan.getAptId(),cancelSchedulePlan.getPatientId(),cancelSchedulePlan.getUserId(),phoneNumber,emailID,msg,createDateTime,sessionId,type,messageCategory);
		
		 /* cisResult = cancelRescheduleplanDAO.getpatientDetails(aptId);
		 
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
          String pemailId=emailid.getEmailid();*/
          
		  try {
			cisResult=smsCommunicaiton.sendMessages(userId,msgs);
			} catch (Throwable e) {
				
				e.printStackTrace();
				cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
				cisResult.setErrorMessage(CISConstants.SMS_FAILED);
			} 
		
		  if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  {
			  cisResult=sendMail.sendMail(pemailId,Pfname,Plname,apptWith,serviceType,startTime,patientId);
			  cisResult=sendMail.sendMailAdmin(Pfname,Plname,apptWith,serviceType,startTime,patientId);
				
		  }
		
		  logger.info("DigitalHealthCare:cancel schedulePlan BL  service" +cisResult );
		  return cisResult;
		}
	

}
