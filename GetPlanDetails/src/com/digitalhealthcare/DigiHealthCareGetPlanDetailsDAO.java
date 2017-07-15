/**
 * 
 */
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
public class DigiHealthCareGetPlanDetailsDAO extends JdbcDaoSupport {


	public List<DigihealthCareSavePlanDetailsModel> getplanDetaialsData(String patientId, String userId) {
		
		CISResults cisResults=new CISResults();
		List<DigihealthCareSavePlanDetailsModel> getplans=null;
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Logger logger = Logger.getLogger(DigiHealthCareGetPlanDetailsDAO.class);
		Object[] inputs = new Object[]{patientId};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 getplans =getJdbcTemplate().query(DigiHealthCareGetPlanDetailsQuery.SQL_PLANSDATA,inputs,new DigiHealthCareGetPlanDetailsMapper());
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("Get PlanDetails data query time:: " +result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get  Data");
		}
   		return getplans; 
	}

}
