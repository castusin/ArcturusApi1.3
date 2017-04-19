
package com.digitalhealthcare;
import org.apache.log4j.Logger;

import com.cis.CISResults;

/**
 * @author 
 *
 */
public class DigihealthCareRescheduleWebservice {

	public CISResults reschedulePlan(String userId,String dateTime) {
		// TODO Auto-generated method stub
		DigihealthCareRescheduleBL rescheduleBL = new DigihealthCareRescheduleBL();
		 Logger logger = Logger.getLogger(DigiHealthCareGetPlanDetailsWebservice.class);
		 CISResults cisResult = rescheduleBL.reschedulePlan(userId,dateTime);
		 logger.info(" DigitalHealthCare: send message details :"+cisResult);
		return cisResult;
	}

}
