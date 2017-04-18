/**
 * 
 */
package com.cis;

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
public class CISSessionWebservice {

	/**
	 * @param userId
	 * @param sessionId
	 * @return
	 */
	public CISResults getSessionDetails(String userId, String sessionId) {
		// TODO Auto-generated method stub
		CISSessionBL cisSessionBl = new CISSessionBL();
		CISResults cisResults=cisSessionBl.getSessionDetails(userId,sessionId);
		return cisResults;
	}

}
