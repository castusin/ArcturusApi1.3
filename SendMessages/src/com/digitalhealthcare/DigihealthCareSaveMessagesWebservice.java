
package com.digitalhealthcare;
import org.apache.log4j.Logger;

import com.cis.CISResults;

/**
 * @author 
 *
 */
public class DigihealthCareSaveMessagesWebservice {

	public CISResults sendMessages(DigihealthCareSaveMessagesModel saveMessages) {
		
		 DigihealthCareSaveMessagesBL saveMessagesBL = new DigihealthCareSaveMessagesBL();
		 Logger logger = Logger.getLogger(DigiHealthCareGetPlanDetailsWebservice.class);
		 CISResults cisResult = saveMessagesBL.sendMessages( saveMessages);
		 logger.info(" DigitalHealthCare: send message details :"+cisResult);
		return cisResult;
	}

}
