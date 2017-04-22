
package com.digitalhealthcare;
import org.apache.log4j.Logger;

import com.cis.CISResults;

/**
 * @author 
 *
 */
public class DigihealthCareRescheduleWebservice {

	public CISResults reschedulePlan(DigihealthCareRescheduleModel reschedulePlans) {
		// TODO Auto-generated method stub
		DigihealthCareRescheduleBL rescheduleBL = new DigihealthCareRescheduleBL();
		 Logger logger = Logger.getLogger(DigiHealthCareGetPlanDetailsWebservice.class);
		 CISResults cisResult = rescheduleBL.reschedulePlan( reschedulePlans);
		 logger.info(" DigitalHealthCare: reschedulePlan details :"+cisResult);
		return cisResult;
	}

}
