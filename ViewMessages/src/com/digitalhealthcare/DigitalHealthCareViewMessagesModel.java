package com.digitalhealthcare;

import java.sql.Date;

public class DigitalHealthCareViewMessagesModel {
	
	String userId;
	String patientId;
	String messageId;
	int aptId;
	String messageText;
	String phoneNumber;
	String emailId;
	Date createDate;
	String aptStarttime;
	String aptEndtime;

	public DigitalHealthCareViewMessagesModel(int aptId, String userId, String messageId, String messageText, String phoneNumber, String emailId, Date createDate, String aptStarttime, String aptEndtime, String patientId) {
		super();
		this.aptId = aptId;
		this.userId = userId;
		this.messageId = messageId;
		this.messageText = messageText;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.createDate = createDate;
		this.aptStarttime=aptStarttime;
		this.aptEndtime=aptEndtime;
		
		this.patientId=patientId;
	}
	

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


	public int getAptId() {
		return aptId;
	}


	public void setAptId(int aptId) {
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
