
package com.digitalhealthcare;
import org.apache.log4j.Logger;

import com.cis.CISResults;

public class DigitalHealthCareProfileDeleteServiceWebservice {

	public CISResults deleteProfile(String userId) {
		// TODO Auto-generated method stub
		DigitalHealthCareProfileDeleteServiceBL profileDeleteServiceBL = new DigitalHealthCareProfileDeleteServiceBL();
		 Logger logger = Logger.getLogger(DigitalHealthCareProfileDeleteServiceWebservice.class);
		 CISResults cisResult = profileDeleteServiceBL.deleteProfile(userId);
		 logger.info(" DigitalHealthCare: delete profile webservice :"+cisResult);
		return cisResult;
	}

}
