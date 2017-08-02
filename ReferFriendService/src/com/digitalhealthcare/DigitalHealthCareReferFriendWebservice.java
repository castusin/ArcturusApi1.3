
package com.digitalhealthcare;


import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;

import com.cis.CISResults;


public class DigitalHealthCareReferFriendWebservice {
	
	static Logger logger = Logger.getLogger(DigitalHealthCareReferFriendWebservice.class);
	
	DigitalHealthCareReferFriendBL referFriendBL=new DigitalHealthCareReferFriendBL();

	public CISResults referFriend( DigitalHealthCareReferFriendModel referFriend){
	CISResults cisResult = referFriendBL.referFriend(referFriend);
	logger.info(" DigitalHealthCare:refer friend webService :"+cisResult);
    return cisResult;
	}
}