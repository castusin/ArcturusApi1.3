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

	public CISResults getPlanDetails(String patientId, String userId) {
		DigiHealthCareGetPlanDetailsBL getplanDetailsBL = new DigiHealthCareGetPlanDetailsBL();
		 Logger logger = Logger.getLogger(DigiHealthCareGetPlanDetailsWebservice.class);
		 CISResults cisResult = getplanDetailsBL.DigiHealthCareGetPlanDetailsBL(patientId,userId);
		 logger.info(" DigitalHealthCare: getPlanDetails :"+cisResult);
		return cisResult;
	}

}
