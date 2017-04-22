
package com.digitalhealthcare;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author 
 *
 */
public class DigihealthCareSaveMessagesModel {

	public int aptId;
	
	public String patientId;
	public String userId;
	public int phoneNumber;
	public String emailId;
	public String messageText;
	
	public Date createDate;
	public String sessionId;
	
	
	
	public DigihealthCareSaveMessagesModel(int aptId, String userId,
			int aptPersonId, String type, String appWith, String status,
			Timestamp aptDate, Date createDate, String patientId, int phoneNumber, String emailId, String messageText, String sessionId) {
		super();
		this.aptId = aptId;
		this.userId = userId;
		this.patientId = patientId;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.messageText = messageText;
		this.sessionId=sessionId;
		this.createDate = createDate;
	}
	
	public int getAptId() {
		return aptId;
	}
	public void setAptId(int aptId) {
		this.aptId = aptId;
	}
	
	
	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
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

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public DigihealthCareSaveMessagesModel()
	{}
}
