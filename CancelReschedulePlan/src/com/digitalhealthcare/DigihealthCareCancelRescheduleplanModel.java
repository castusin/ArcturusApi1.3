

package com.digitalhealthcare;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author 
 *
 */
public class DigihealthCareCancelRescheduleplanModel {

	public String aptId;
	public String userId;
	public String patientId;
	public int phoneNumber;
	public String emailId;
	
	public String messageText;
	
	public Date createDateTime;
	public Date dateTime;
	public String sessionId;
	public String type;
	public String messageCategory;
	public DigihealthCareCancelRescheduleplanModel(String aptId, String userId,
			
			 Date createDate, String patientId, String messageText, Date createDateTime, Date dateTime, String sessionId, int phoneNumber, String emailId, String type, String messageCategory) {
		super();
		this.aptId = aptId;
		this.userId = userId;
		this.patientId = patientId;
		this.messageText = messageText;
		this.createDateTime = createDateTime;
		this.dateTime = dateTime;
		this.sessionId=sessionId;
		this.phoneNumber=phoneNumber;
		this.emailId=emailId;
		this.type=type;
		this.messageCategory=messageCategory;
	}
	
	
	public String getMessageCategory() {
		return messageCategory;
	}


	public void setMessageCategory(String messageCategory) {
		this.messageCategory = messageCategory;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getAptId() {
		return aptId;
	}


	public void setAptId(String aptId) {
		this.aptId = aptId;
	}


	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public DigihealthCareCancelRescheduleplanModel()
	{}
}
