
package com.digitalhealthcare;
import org.apache.log4j.Logger;

import com.cis.CISResults;

/**
 * @author 
 *
 */
public class DigihealthCareSaveMessagesWebservice {

	public CISResults sendMessages(String userId,String message) {
		// TODO Auto-generated method stub
		DigihealthCareSaveMessagesBL saveMessagesBL = new DigihealthCareSaveMessagesBL();
		 Logger logger = Logger.getLogger(DigiHealthCareGetPlanDetailsWebservice.class);
		 CISResults cisResult = saveMessagesBL.sendMessages(userId,message);
		 logger.info(" DigitalHealthCare: send message details :"+cisResult);
		return cisResult;
	}

}
