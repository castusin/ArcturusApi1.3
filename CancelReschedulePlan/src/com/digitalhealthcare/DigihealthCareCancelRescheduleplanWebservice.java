
package com.digitalhealthcare;
import org.apache.log4j.Logger;

import com.cis.CISResults;

/**
 * @author 
 *
 */
public class DigihealthCareCancelRescheduleplanWebservice {

	public CISResults cancelSchedulePlan(DigihealthCareCancelRescheduleplanModel cancelSchedulePlan) {
		
		DigihealthCareCancelRescheduleplanBL cancelRescheduleplanBL = new DigihealthCareCancelRescheduleplanBL();
		 Logger logger = Logger.getLogger(DigihealthCareCancelRescheduleplanWebservice.class);
		 CISResults cisResult = cancelRescheduleplanBL.cancelSchedulePlan(cancelSchedulePlan);
		 logger.info(" DigitalHealthCare: reschedulePlan details :"+cisResult);
		return cisResult;
	}

}
