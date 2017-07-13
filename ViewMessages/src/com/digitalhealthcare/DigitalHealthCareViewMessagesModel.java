package com.digitalhealthcare;

import java.sql.Date;

public class DigitalHealthCareViewMessagesModel {
	
	String userId;
	String patientId;
	String messageId;
	String aptId;
	String messageText;
	String phoneNumber;
	String emailId;
	Date createDate;
	String aptStarttime;
	String aptEndtime;
	//String type;
	String aptWith;
    String title;
	String messageType;
	


	


	public String getAptWith() {
		return aptWith;
	}


	public void setAptWith(String aptWith) {
		this.aptWith = aptWith;
	}


	public DigitalHealthCareViewMessagesModel(String userId, String patientId,
			String messageId, String aptId, String messageText,
			String phoneNumber, String emailId, Date createDate,
			String aptStarttime, String aptEndtime, String type, String aptWith, String messageType, String title) {
		super();
		this.userId = userId;
		this.patientId = patientId;
		this.messageId = messageId;
		this.aptId = aptId;
		this.messageText = messageText;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.createDate = createDate;
		this.aptStarttime = aptStarttime;
		this.aptEndtime = aptEndtime;
		//this.type = type;
		this.aptWith = aptWith;
		this.messageType=messageType;
		this.title=title;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getMessageType() {
		return messageType;
	}


	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}


	/*public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}*/


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getPatientId() {
		return patientId;
	}


	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}


	public String getMessageId() {
		return messageId;
	}


	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}


	

	public String getAptId() {
		return aptId;
	}


	public void setAptId(String aptId) {
		this.aptId = aptId;
	}


	public String getMessageText() {
		return messageText;
	}


	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public String getAptStarttime() {
		return aptStarttime;
	}


	public void setAptStarttime(String aptStarttime) {
		this.aptStarttime = aptStarttime;
	}


	public String getAptEndtime() {
		return aptEndtime;
	}


	public void setAptEndtime(String aptEndtime) {
		this.aptEndtime = aptEndtime;
	}


	public DigitalHealthCareViewMessagesModel()
	{}
}
