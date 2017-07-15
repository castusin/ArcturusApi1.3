/**
 * 
 */
package com.digitalhealthcare;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISResults;

/**
 * @author 
 *
 */
public class DigiHealthCareGetPlanDetailsBL {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigiHealthCareGetPlanDetailsDAO getplansDAO=(DigiHealthCareGetPlanDetailsDAO)ctx.getBean("getplansDAO");


	public CISResults DigiHealthCareGetPlanDetailsBL(String patientId, String userId) {
		
		CISResults cisResults=new CISResults();
		final Logger logger = Logger.getLogger(DigiHealthCareGetPlanDetailsBL.class);
	    List<DigihealthCareSavePlanDetailsModel> getPlans = getplansDAO.getplanDetaialsData(patientId,userId);
		
	    
		ArrayList<Object> getplans = new ArrayList<Object>();
		 
		for (int i = 0; i < getPlans.size(); i++) {
			
			DigihealthCareSavePlanDetailsModel getPlanDetails = new DigihealthCareSavePlanDetailsModel();
			 String aptId = getPlans.get(i).aptId;;
			 int aptPersonId = getPlans.get(i).aptPersonId;;
			
			 String appWith = getPlans.get(i).appWith;;
			 String status = getPlans.get(i).status;
			 String aptDate = getPlans.get(i).aptDate;;
			 Date createDate = getPlans.get(i).createDate;
			 boolean allDay = getPlans.get(i).allDay;
			 String startTime = getPlans.get(i).startTime;
			 String endTime = getPlans.get(i).endTime;
		     String color = getPlans.get(i).color;
			 String title= getPlans.get(i).title;
			 
			getPlanDetails.setAptPersonId(aptPersonId);
			getPlanDetails.setAptId(aptId);
			getPlanDetails.setUserId(userId);
			getPlanDetails.setTitle(title);
			getPlanDetails.setAppWith(appWith);
			getPlanDetails.setStatus(status);
			getPlanDetails.setAptDate(aptDate);
			getPlanDetails.setCreateDate(createDate);
			getPlanDetails.setAllDay(allDay);
			getPlanDetails.setStartTime(startTime);
			getPlanDetails.setEndTime(endTime);
			getPlanDetails.setPatientId(patientId);
			getPlanDetails.setColor(color);
			
			
			 if(title.equalsIgnoreCase("Chaplain"))
		      {
				 
		    	  getPlanDetails.setColor("#0C61AB");
		      }
			
			 if(title.equalsIgnoreCase("Social Worker"))
		      {
				
		    	 
		    	  getPlanDetails.setColor("#8B1B32");
		      }
			 
			 if(title.equalsIgnoreCase("CNA"))
		      {
		    	  
		    	  getPlanDetails.setColor("#BD21BF");
		      }
			 
			 if(title.equalsIgnoreCase("Nurse"))
		      {
		    	 
		    	  getPlanDetails.setColor("#17BA2A");
		      }
			 if(title.equalsIgnoreCase("Doctor"))
		       {
		    	  
		    	  getPlanDetails.setColor("#F60529");
		    	 
		       }
			 getplans.add(getPlanDetails);
				
		}
			
		 cisResults.setResultObject(getplans);
		logger.info("DigitalHealthCare:Get plan details  DataBL  service" +cisResults );
		
		
		
		
		
		return cisResults;
	}
	

}
