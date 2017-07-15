
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
	
	@RequestMapping(value="/reschedulePlan",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	
	public String reschedulePlan(HttpServletRequest request,@RequestBody DigihealthCareRescheduleModel reschedulePlans) throws Exception{
		    Logger logger = Logger.getLogger(DigitalHealthCareGetReschedulePlanDetailsRest.class);
		    CommonCISValidation CommonCISValidation=new CommonCISValidation();
		    CISResults cisResults=CommonCISValidation.getReschedulePlanDetaisValidation(reschedulePlans,request);
		    if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		     {
		    	DigihealthCareRescheduleWebservice rescheduleWebservice= new DigihealthCareRescheduleWebservice();
		       cisResults  = rescheduleWebservice.reschedulePlan(reschedulePlans);
		       logger.info(" DigitalHealthCare: getreschedulePlan details :"+cisResults);
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
