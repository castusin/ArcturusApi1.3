
package com.digitalhealthcare;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISResults;

/**
 * @author 
 *
 */
public class DigitalHealthCareProfileDeleteServiceBL {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigitalHealthCareProfileDeleteServiceDAO profileDeleteServiceDAO=(DigitalHealthCareProfileDeleteServiceDAO)ctx.getBean("deleteProfile");


	public CISResults deleteProfile(String userId) {
		
		final Logger logger = Logger.getLogger(DigitalHealthCareViewMessagesBL.class);
		CISResults cisResult = profileDeleteServiceDAO.deleteProfile(userId);
		cisResult = profileDeleteServiceDAO.deleteUserDevice(userId);
		cisResult = profileDeleteServiceDAO.deletePatientfm(userId);
		cisResult = profileDeleteServiceDAO.deletePatientPhone(userId);
		logger.info("DigitalHealthCare:delete profile BL  service" +cisResult );
		return cisResult;
	}
	

}
