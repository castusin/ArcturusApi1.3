
package com.digitalhealthcare;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISResults;

/**
 * @author 
 *
 */
public class DigitalHealthCareViewMessagesBL {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigitalHealthCareViewMessagesDAO viewMessagesDAO=(DigitalHealthCareViewMessagesDAO)ctx.getBean("viewMessagesDAO");


	public CISResults viewMessages(String patientId, String userId) {
		final Logger logger = Logger.getLogger(DigitalHealthCareViewMessagesBL.class);
		CISResults cisResult = viewMessagesDAO.viewMessages(patientId,userId);
		logger.info("DigitalHealthCare:view messages BL  service" +cisResult );
		return cisResult;
	}
	

}
