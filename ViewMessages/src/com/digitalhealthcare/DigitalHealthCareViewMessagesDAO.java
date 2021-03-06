
package com.digitalhealthcare;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;

/**
 * @author 
 *
 */
public class DigitalHealthCareViewMessagesDAO extends JdbcDaoSupport {


	public CISResults viewMessages(String patientId, String userId) {
	    CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Logger logger = Logger.getLogger(DigiHealthCareGetPlanDetailsDAO.class);
		Object[] inputs = new Object[]{patientId};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 List viewMessages=getJdbcTemplate().query(DigitalHealthCareViewMessagesQuery.SQL_VIEWMESSAGES,inputs,new DigitalHealthCareViewMessagesMapper());
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 cisResults.setResultObject(viewMessages);
			 logger.info("view messages query time:: " +result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get  Data");
		}
   		return cisResults; 
	}

}
