
package com.digitalhealthcare;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class DigitalHealthCareReferFriendBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigitalHealthCareReferFriendDAO referFriendDAO=(DigitalHealthCareReferFriendDAO)ctx.getBean("ReferFriend");
	// private static final AtomicInteger count = new AtomicInteger(111101);
	public CISResults referFriend(DigitalHealthCareReferFriendModel referFriend){
		
		final Logger logger = Logger.getLogger(DigitalHealthCareReferFriendBL.class);
		
		DigitalHealthCareReferFriendModel friend=new DigitalHealthCareReferFriendModel();
		// Capture service Start time
		 TimeCheck time=new TimeCheck();
		 testServiceTime seriveTimeCheck=new testServiceTime();
		 String serviceStartTime=time.getTimeZone();
		 Calendar currentdate = Calendar.getInstance();
	     DateFormat formatter = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
	     TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
	     formatter.setTimeZone(obj);
	     String createDate=time.getTimeZone();
	   
		 CISResults cisResult = referFriendDAO.referFriend(friend.getPatientId(),friend.getFamilyMemeberId(),friend.getFriendName(),friend.getEmailId(),friend.getPhoneNumber(),friend.getFreeText(),createDate);
		
		// Capture Service End time
		  String serviceEndTime=time.getTimeZone();
		  long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		  logger.info("Database time for save staff member service:: " +result );
		  
		return cisResult;
	}


}