/**
 * 
 */
package com.cis;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Session Time check service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */
public class CISSessionDAO extends JdbcDaoSupport {

	/**
	 * @param userId
	 * @param sessionId
	 * @param deleteInd
	 * @return
	 */
	public CISResults getSessionDetails(String userId, String sessionId,String deleteInd) {
		// TODO Auto-generated method stub
		
		CISSessionModel sessionsModel;
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{userId,sessionId,deleteInd};
		try{	
			sessionsModel=(CISSessionModel)getJdbcTemplate().queryForObject(CISSessionDBQuery.SQL_SESSION_TIME_CHECK,inputs,new CISSessionMapper());
			
			if(sessionsModel!=null){
				cisResults.setResultObject(sessionsModel);
			}
			
		
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage(CISConstants.USER_USERID_SESSION_STATUS);
		}
		
		return cisResults;
	}

	public CISResults updateSessionTime(String userId, String sessionId,
			String currentDateTime) {
		// TODO Auto-generated method stub
		CISResults cisResults=new CISResults();
		Object[] inputs = new Object[]{currentDateTime,userId,sessionId};
		try{
			getJdbcTemplate().update(CISSessionDBQuery.SQL_SESSION_TIME_UPDATE,inputs);
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Data Access Error");
		}

   		return cisResults;  
	
	}


}
