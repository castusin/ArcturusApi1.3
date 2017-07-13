
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


@RestController
public class DigitalHealthCareProfileDeleteServiceRest {
	
	@RequestMapping(value="/deleteProfile",method=RequestMethod.GET,produces={"application/json"})

	 public String deleteProfile(@RequestParam ("userId") String userId,HttpServletRequest request){
		    Logger logger = Logger.getLogger(DigitalHealthCareProfileDeleteServiceRest.class);
			String deleteProfileParameters = "userId=" +userId;
		    logger.info(" DigitalHealthCare:delete profile details :"+deleteProfileParameters);
            CommonCISValidation CommonCISValidation=new CommonCISValidation();
		    CISResults cisResults=CommonCISValidation.deleteProfileValidation(userId,request);
		    if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		     {
		    	DigitalHealthCareProfileDeleteServiceWebservice profileDeleteWebservice= new DigitalHealthCareProfileDeleteServiceWebservice();
		       cisResults  = profileDeleteWebservice.deleteProfile(userId);
		       logger.info(" DigitalHealthCare: delete profile :"+cisResults);
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
