/**
 * 
 */
package com.cis;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Session Time check service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */
    public class CISSessionBL {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	CISSessionDAO sessionCheckDAO=(CISSessionDAO)ctx.getBean("sessionHandler");
	/**
	 * @param userId
	 * @param sessionId
	 * @return
	 */
	public CISResults getSessionDetails(String userId, String sessionId) {
		// TODO Auto-generated method stub
		SessionTimeCheck sessionTimeCheck=new SessionTimeCheck();
		String deleteInd=CISConstants.DELETE_IND;
		String sessionTime="";
		 Calendar currentdate = Calendar.getInstance();
	      DateFormat formatter = new SimpleDateFormat(CISConstants.DATE_FORMAT);
	      TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
	      formatter.setTimeZone(obj);
	      //System.out.println("Local:: " +currentdate.getTime());
	     // System.out.println("CST:: "+ formatter.format(currentdate.getTime()));
		  CISResults cisResult = sessionCheckDAO.getSessionDetails(userId,sessionId,deleteInd);
		if(cisResult.getResponseCode().contentEquals(CISConstants.RESPONSE_SUCCESS)){
			CISSessionModel cisSessionMapper=(CISSessionModel)cisResult.getResultObject();
			sessionTime=cisSessionMapper.getTimeStamp();
			String currentDateTime = formatter.format(currentdate.getTime());
			cisResult=sessionTimeCheck.checkSessionTime(currentDateTime,sessionTime);
			if(cisResult.getResponseCode().contentEquals(CISConstants.RESPONSE_SUCCESS)){
			   cisResult=sessionCheckDAO.updateSessionTime(userId,sessionId,currentDateTime);
			}
		}
		return cisResult;
	}

}
