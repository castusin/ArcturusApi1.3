
package com.digitalhealthcare;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author 
 *
 */
public class DigihealthCareRescheduleModel {

	public int aptId;
	public String userId;
	public int patientId;
	
	
	public String messageText;
	
	public Date createDateTime;
	public Date dateTime;
	public String sessionId;
	
	public DigihealthCareRescheduleModel(int aptId, String userId,
			
			 Date createDate, int patientId, String messageText, Date createDateTime, Date dateTime, String sessionId) {
		super();
		this.aptId = aptId;
		this.userId = userId;
		this.patientId = patientId;
		this.messageText = messageText;
		this.createDateTime = createDateTime;
		this.dateTime = dateTime;
		this.sessionId=sessionId;
	}
	
	public int getAptId() {
		return aptId;
	}
	public void setAptId(int aptId) {
		this.aptId = aptId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
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

	public DigihealthCareRescheduleModel()
	{}
}
