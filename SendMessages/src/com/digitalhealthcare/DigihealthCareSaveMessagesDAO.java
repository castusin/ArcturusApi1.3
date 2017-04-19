
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
public class DigihealthCareSaveMessagesDAO extends JdbcDaoSupport {


	public CISResults sendMessages(String userId,String message) {
		// TODO Auto-generated method stub
		
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Logger logger = Logger.getLogger(DigihealthCareSaveMessagesDAO.class);
		Object[] inputs = new Object[]{userId};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 List planDetails=getJdbcTemplate().query(DigihealthCareSaveMessagesQuery.SQL_PLANSDATA,inputs,new DigiHealthCareGetPlanDetailsMapper());
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 cisResults.setResultObject(planDetails);
			 logger.info("Get PlanDetails data query time:: " +result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get Profile Data");
		}
   		return cisResults; 
	}

}
