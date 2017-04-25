package com.validation;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.CISSessionWebservice;
import com.digitalhealthcare.DigihealthCareCancelRescheduleplanModel;
import com.digitalhealthcare.DigihealthCareRescheduleModel;
import com.digitalhealthcare.DigihealthCareSaveMessagesModel;


public class CommonCISValidation {
	
	
	


	public CISResults getPlanDetaisValidation(String patientId,String userId,HttpServletRequest request) {
		// TODO Auto-generated method stub
		CISResults cisResult=new CISResults();
		CISSessionWebservice cisSessionTime = new CISSessionWebservice();
		ArrayList<String> emptyValidatonArray= new ArrayList<String>();
		emptyValidatonArray.add(patientId);
		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
			String headerAuthorization=request.getHeader(CISConstants.HEADERS_AUTHROIZATION);
	        //Validate Headers AUTHROIZATION
	   if(headerAuthorization.equals(CISConstants.HEADERS_AUTHROIZATION_VAUE))
	         {
		               cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
	         }else
	         {
		               cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	          }
	   
	   
	        // Validate Null Values 
	   if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  {
	   
			 for (String st : emptyValidatonArray) {
		            if  (st==null || st.equals(""))
		            	cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
		          } 
		  }
	   //Validate Session Time
		 /* if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
			 {
		       cisResult  = cisSessionTime.getSessionDetails(patientId,sessionId);
		  
			 }*/
			return cisResult;
	}
	public CISResults viewMessagesValidation(String patientId,String userId,HttpServletRequest request) {
		// TODO Auto-generated method stub
		CISResults cisResult=new CISResults();
		CISSessionWebservice cisSessionTime = new CISSessionWebservice();
		ArrayList<String> emptyValidatonArray= new ArrayList<String>();
		emptyValidatonArray.add(patientId);
		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
			String headerAuthorization=request.getHeader(CISConstants.HEADERS_AUTHROIZATION);
	        //Validate Headers AUTHROIZATION
	   if(headerAuthorization.equals(CISConstants.HEADERS_AUTHROIZATION_VAUE))
	         {
		               cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
	         }else
	         {
		               cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	          }
	   
	   
	        // Validate Null Values 
	   if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  {
	   
			 for (String st : emptyValidatonArray) {
		            if  (st==null || st.equals(""))
		            	cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
		          } 
		  }
	   //Validate Session Time
		 /* if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
			 {
		       cisResult  = cisSessionTime.getSessionDetails(patientId,sessionId);
		  
			 }*/
			return cisResult;
	}
	
	public CISResults getReschedulePlanDetaisValidation(DigihealthCareRescheduleModel reschedulePlans,HttpServletRequest request) {
		// TODO Auto-generated method stub
		CISResults cisResult=new CISResults();
		CISSessionWebservice cisSessionTime = new CISSessionWebservice();
		ArrayList<String> emptyValidatonArray= new ArrayList<String>();
		//emptyValidatonArray.add(userId);
		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
			String headerAuthorization=request.getHeader(CISConstants.HEADERS_AUTHROIZATION);
	        //Validate Headers AUTHROIZATION
	   if(headerAuthorization.equals(CISConstants.HEADERS_AUTHROIZATION_VAUE))
	         {
		               cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
	         }else
	         {
		               cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	          }
	   
	   
	        // Validate Null Values 
	   if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  {
	   
			 for (String st : emptyValidatonArray) {
		            if  (st==null || st.equals(""))
		            	cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
		          } 
		  }
	   //Validate Session Time
		  /*if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
			 {
		       cisResult  = cisSessionTime.getSessionDetails(userId,sessionId);
		  
			 }*/
			return cisResult;
	}
	
	
	
	public CISResults sendMessagesValidation(HttpServletRequest request,DigihealthCareSaveMessagesModel saveMessages) {
		// TODO Auto-generated method stub
		CISResults cisResult=new CISResults();
		CISSessionWebservice cisSessionTime = new CISSessionWebservice();
		ArrayList<String> emptyValidatonArray= new ArrayList<String>();
		//emptyValidatonArray.add(userId);
		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
			String headerAuthorization=request.getHeader(CISConstants.HEADERS_AUTHROIZATION);
	        //Validate Headers AUTHROIZATION
	   if(headerAuthorization.equals(CISConstants.HEADERS_AUTHROIZATION_VAUE))
	         {
		               cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
	         }else
	         {
		               cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	          }
	   
	   
	        // Validate Null Values 
	   if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  {
	   
			 for (String st : emptyValidatonArray) {
		            if  (st==null || st.equals(""))
		            	cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
		          } 
		  }
	   //Validate Session Time
		 /*if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
			 {
		       cisResult  = cisSessionTime.getSessionDetails(userId,sessionId);
		  
			 }*/
			return cisResult;
	}
	
	public CISResults cancelSchedulePlanValidation(HttpServletRequest request,DigihealthCareCancelRescheduleplanModel cancelSchedulePlan) {
		// TODO Auto-generated method stub
		CISResults cisResult=new CISResults();
		CISSessionWebservice cisSessionTime = new CISSessionWebservice();
		ArrayList<String> emptyValidatonArray= new ArrayList<String>();
		//emptyValidatonArray.add(userId);
		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
			String headerAuthorization=request.getHeader(CISConstants.HEADERS_AUTHROIZATION);
	        //Validate Headers AUTHROIZATION
	   if(headerAuthorization.equals(CISConstants.HEADERS_AUTHROIZATION_VAUE))
	         {
		               cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
	         }else
	         {
		               cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	          }
	   
	   
	        // Validate Null Values 
	   if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  {
	   
			 for (String st : emptyValidatonArray) {
		            if  (st==null || st.equals(""))
		            	cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
		          } 
		  }
	   //Validate Session Time
		  /*if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
			 {
		       cisResult  = cisSessionTime.getSessionDetails(userId,sessionId);
		  
			 }*/
			return cisResult;
	}
	
	
}
