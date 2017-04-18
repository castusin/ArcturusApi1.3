/**
 * 
 */
package com.digitalhealthcare;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISResults;

/**
 * @author Darshan
 *
 */
public class DigiHealthCareGetPlanDetailsBL {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigiHealthCareGetPlanDetailsDAO getplansDAO=(DigiHealthCareGetPlanDetailsDAO)ctx.getBean("getplansDAO");


	public CISResults DigiHealthCareGetPlanDetailsBL(String userId) {
		// TODO Auto-generated method stub
		
		final Logger logger = Logger.getLogger(DigiHealthCareGetPlanDetailsBL.class);
		CISResults cisResult = getplansDAO.getplanDetaialsData(userId);
		logger.info("DigitalHealthCare:ProfileDataBL  service" +cisResult );
		return cisResult;
	}
	

}
