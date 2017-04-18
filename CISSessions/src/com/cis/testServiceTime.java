/**
 * 
 */
package com.cis;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * @author Darshan
 *
 */
public class testServiceTime {
	public long getServiceTime(String currentDateTime, String otpTimeGenerateTime) {
		
		Logger logger = Logger.getLogger(testServiceTime.class);
	    SimpleDateFormat format = new SimpleDateFormat(CISConstants.DATE_FORMAT);
	    CISResults cisResult=new CISResults();
	    Date d1 = null;
	    Date d2 = null;
	    long diffInMilliSeconds = 0;
	    
	    try {
		 d1 = format.parse(currentDateTime);
		 d2 = format.parse(otpTimeGenerateTime);
        
		//in milliseconds
		 diffInMilliSeconds = d1.getTime()- d2.getTime();
		
		logger.info("Service time in milli seconds:: " +diffInMilliSeconds );
		

	} catch (Exception e) {
		e.printStackTrace();
	}
		return diffInMilliSeconds;
	
	}
}
