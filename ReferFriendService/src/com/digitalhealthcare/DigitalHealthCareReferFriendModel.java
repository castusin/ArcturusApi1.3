package com.digitalhealthcare;

import java.sql.Date;

public class DigitalHealthCareReferFriendModel {
	
	
	String  patientId;
	String familyMemeberId;
	String friendName;
	String emailId;
	String phoneNumber;
	String freeText;
	String datetime;
	



	public DigitalHealthCareReferFriendModel(String patientId, String familyMemeberId, String friendName, String emailId, String phoneNumber, String freeText, String datetime) {
		super();
		this.patientId = patientId;
		this.familyMemeberId=familyMemeberId;
		this.friendName=friendName;
		this.emailId=emailId;
		this.phoneNumber=phoneNumber;
		this.freeText=freeText;
		this.datetime=datetime;
	
	}



	public String getPatientId() {
		return patientId;
	}


	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getFamilyMemeberId() {
		return familyMemeberId;
	}

	public void setFamilyMemeberId(String familyMemeberId) {
		this.familyMemeberId = familyMemeberId;
	}


	public String getFriendName() {
		return friendName;
	}


	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getFreeText() {
		return freeText;
	}


	public void setFreeText(String freeText) {
		this.freeText = freeText;
	}


	public String getDatetime() {
		return datetime;
	}


	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public DigitalHealthCareReferFriendModel()
	{}
}
