/**
 * 
 */
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
 * Rest Controller : Get Content Service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */
@RestController
public class DigitalHealthCareGetPatientPlanDetailsRest {
	
	@RequestMapping(value="/getPlanDetais",method=RequestMethod.GET,produces={"application/json"})

	 public String getPlanDetais(@RequestParam ("patientId") String patientId,@RequestParam ("userId") String userId,HttpServletRequest request){
		    Logger logger = Logger.getLogger(DigitalHealthCareGetPatientPlanDetailsRest.class);
			String getPlanDetaisParameters = "patientId=" +patientId;
		    logger.info(" DigitalHealthCare:Get plan details :"+getPlanDetaisParameters);
            CommonCISValidation CommonCISValidation=new CommonCISValidation();
		    CISResults cisResults=CommonCISValidation.getPlanDetaisValidation(patientId,userId,request);
		    if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		     {
		    	DigiHealthCareGetPlanDetailsWebservice getPlanDetailsWebService= new DigiHealthCareGetPlanDetailsWebservice();
		       cisResults  = getPlanDetailsWebService.getPlanDetails(patientId,userId);
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
