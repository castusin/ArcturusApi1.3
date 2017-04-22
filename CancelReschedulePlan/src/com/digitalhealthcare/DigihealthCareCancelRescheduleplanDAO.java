package com.digitalhealthcare;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;

public class DigihealthCareCancelRescheduleplanDAO extends JdbcDaoSupport {

	public CISResults cancelSchedulePlan(String messageId, int aptId,
			String patientId, String userId, String phoneNumber,
			String emailID, String messageText, String createDateTime,
			String sessionId) {
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Logger logger = Logger.getLogger(DigihealthCareSaveMessagesDAO.class);
		//Object[] inputs = new Object[]{userId};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			getJdbcTemplate().update(DigihealthCareCancelRescheduleplanQuery.SQL_CANCELRESCHEDULEPLAN,messageId,aptId,patientId,userId,phoneNumber,emailID,messageText,createDateTime);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("Get PlanDetails data query time:: " +result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get Profile Data");
		}
   		return cisResults; 
	}


}
