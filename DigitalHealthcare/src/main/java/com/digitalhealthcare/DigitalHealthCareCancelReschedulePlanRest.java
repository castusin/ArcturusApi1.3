
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
public class DigitalHealthCareCancelReschedulePlanRest {
	
	
	@RequestMapping(value="/cancelSchedulePlan",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	
	public String cancelSchedulePlan(HttpServletRequest request,@RequestBody DigihealthCareCancelRescheduleplanModel cancelSchedulePlan){
		 
		Logger logger = Logger.getLogger(DigitalHealthCareCancelReschedulePlanRest.class);
			
            CommonCISValidation CommonCISValidation=new CommonCISValidation();
		    CISResults cisResults=CommonCISValidation.cancelSchedulePlanValidation(request,cancelSchedulePlan);
		    if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		     {
		    	DigihealthCareCancelRescheduleplanWebservice cancelRescheduleplanWebservice= new DigihealthCareCancelRescheduleplanWebservice();
		       cisResults  = cancelRescheduleplanWebservice.cancelSchedulePlan(cancelSchedulePlan);
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
