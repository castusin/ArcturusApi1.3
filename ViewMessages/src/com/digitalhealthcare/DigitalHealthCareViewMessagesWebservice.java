
package com.digitalhealthcare;
import org.apache.log4j.Logger;

import com.cis.CISResults;

/**
 * @author 
 *
 */
public class DigitalHealthCareViewMessagesWebservice {

	public CISResults viewMessages(String patientId, String userId) {
		// TODO Auto-generated method stub
		DigitalHealthCareViewMessagesBL viewMessagesBL = new DigitalHealthCareViewMessagesBL();
		 Logger logger = Logger.getLogger(DigitalHealthCareViewMessagesWebservice.class);
		 CISResults cisResult = viewMessagesBL.viewMessages(patientId,userId);
		 logger.info(" DigitalHealthCare: view messages webservice :"+cisResult);
		return cisResult;
	}

}
