
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
 * Rest Controller : save staff member plan Service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */
@RestController
public class DigitalHealthCareReferFriendServiceRest {
	
	
	@RequestMapping(value="/referFriend",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	
	public String referFriend(HttpServletRequest request,@RequestBody DigitalHealthCareReferFriendModel referFriend){
		 
		Logger logger = Logger.getLogger(DigitalHealthCareReferFriendServiceRest.class);
			
            CommonCISValidation CommonCISValidation=new CommonCISValidation();
		   // CISResults cisResults=CommonCISValidation.saveStaffMemberValidation(request,saveStaffmember);
		    //if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		    // {
            DigitalHealthCareReferFriendWebservice referFriendWebservice= new DigitalHealthCareReferFriendWebservice();
		    	CISResults cisResults  = referFriendWebservice.referFriend(referFriend);
		        logger.info(" DigitalHealthCare: refer friend rest service :"+cisResults);
		    // }
		       return returnJsonData(cisResults);
	 }
	 
	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
}
