
package com.digitalhealthcare;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.google.gson.Gson;
import com.validation.CommonCISValidation;

/**
 * Rest Controller : view messages Service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */
@RestController
public class DigitalHealthCareViewMessagesRest {
	
	@RequestMapping(value="/viewMessages",method=RequestMethod.GET,produces={"application/json"})

	 public String viewMessages(@RequestParam ("patientId") String patientId,@RequestParam ("userId") String userId,HttpServletRequest request){
		    Logger logger = Logger.getLogger(DigitalHealthCareGetPatientPlanDetailsRest.class);
			String viewMessageParameters = "patientId=" +patientId;
		    logger.info(" DigitalHealthCare:Get plan details :"+viewMessageParameters);
            CommonCISValidation CommonCISValidation=new CommonCISValidation();
		    CISResults cisResults=CommonCISValidation.viewMessagesValidation(patientId,userId,request);
		    if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		     {
		    	DigitalHealthCareViewMessagesWebservice viewMessagesWebservice= new DigitalHealthCareViewMessagesWebservice();
		       cisResults  = viewMessagesWebservice.viewMessages(patientId,userId);
		       logger.info(" DigitalHealthCare: getPlandetails :"+cisResults);
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
