/**
 * 
 */
package com.digitalhealthcare;
import org.apache.log4j.Logger;

import com.cis.CISResults;

/**
 * @author Darshan
 *
 */
public class DigiHealthCareGetPlanDetailsWebservice {

	public CISResults getPlanDetails(String userId) {
		// TODO Auto-generated method stub
		DigiHealthCareGetPlanDetailsBL getplanDetailsBL = new DigiHealthCareGetPlanDetailsBL();
		 Logger logger = Logger.getLogger(DigiHealthCareGetPlanDetailsWebservice.class);
		 CISResults cisResult = getplanDetailsBL.DigiHealthCareGetPlanDetailsBL(userId);
		 logger.info(" DigitalHealthCare: getPlanDetails :"+cisResult);
		return cisResult;
	}

}
