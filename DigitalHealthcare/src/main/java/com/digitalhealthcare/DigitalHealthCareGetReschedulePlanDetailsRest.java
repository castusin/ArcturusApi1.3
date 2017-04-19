
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
 * Rest Controller : Get Reschedule plan details Service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */
@RestController
public class DigitalHealthCareGetReschedulePlanDetailsRest {
	
	@RequestMapping(value="/reschedulePlan",method=RequestMethod.GET,produces={"application/json"})

	 public String reschedulePlan(@RequestParam ("userId") String userId,@RequestParam ("sessionId") String sessionId,@RequestParam ("dateTime") String dateTime,HttpServletRequest request){
		    Logger logger = Logger.getLogger(DigitalHealthCareGetPatientPlanDetailsRest.class);
			String getReschedulePlanDetaisParameters = "userId=" +userId;
		    logger.info(" DigitalHealthCare:contentData :"+getReschedulePlanDetaisParameters);
            CommonCISValidation CommonCISValidation=new CommonCISValidation();
		    CISResults cisResults=CommonCISValidation.getReschedulePlanDetaisValidation(userId,sessionId,dateTime,request);
		    if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		     {
		    	DigihealthCareRescheduleWebservice rescheduleWebservice= new DigihealthCareRescheduleWebservice();
		       cisResults  = rescheduleWebservice.reschedulePlan(userId,dateTime);
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
