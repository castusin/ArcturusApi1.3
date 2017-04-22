
package com.digitalhealthcare;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.google.gson.Gson;
import com.validation.CommonCISValidation;

/**
 * Rest Controller : Get sent messages Service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */
@RestController
public class DigitalHealthCareGetSentMessagesRest {
	
	//@RequestMapping(value="/sendMessages",method=RequestMethod.GET,produces={"application/json"})
	@RequestMapping(value="/sendMessages",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	
	public String sendMessages(HttpServletRequest request,@RequestBody DigihealthCareSaveMessagesModel saveMessages){
		 
		Logger logger = Logger.getLogger(DigitalHealthCareGetPatientPlanDetailsRest.class);
			/*String sentMessageParameters = "userId=" +userId;
		    logger.info(" DigitalHealthCare:Send messages :"+sentMessageParameters);*/
            CommonCISValidation CommonCISValidation=new CommonCISValidation();
		    CISResults cisResults=CommonCISValidation.sendMessagesValidation(request,saveMessages);
		    if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		     {
		    	DigihealthCareSaveMessagesWebservice saveMessagesWebservice= new DigihealthCareSaveMessagesWebservice();
		       cisResults  = saveMessagesWebservice.sendMessages(saveMessages);
		       logger.info(" DigitalHealthCare: get send message details :"+cisResults);
		     }
		       return returnJsonData(cisResults);
	 }
	 
	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
}
