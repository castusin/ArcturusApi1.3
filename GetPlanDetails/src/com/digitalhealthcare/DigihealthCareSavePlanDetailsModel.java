/**
 * 
 */
package com.digitalhealthcare;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author Darshan
 *
 */
public class DigihealthCareSavePlanDetailsModel {

	public String aptId;
	public String userId;
	public int aptPersonId;
	public String title;
	public String appWith;
	public String status;
	public String aptDate;
	public Date createDate;
	public boolean allDay;
	public String startTime;
	public String endTime;
	public String patientId;
	public String color;
	
	
	
	
	public DigihealthCareSavePlanDetailsModel(String aptId, String userId,
			int aptPersonId, String title, String appWith, String status,
			String aptDate, Date createDate, boolean allDay, String startTime,
			String endTime, String patientId, String color, String colour) {
		super();
		this.aptId = aptId;
		this.userId = userId;
		this.aptPersonId = aptPersonId;
		this.title = title;
		this.appWith = appWith;
		this.status = status;
		this.aptDate = aptDate;
		this.createDate = createDate;
		this.allDay = allDay;
		this.startTime = startTime;
		this.endTime = endTime;
		this.patientId = patientId;
		this.color=color;
	}

	

	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public String getAptDate() {
		return aptDate;
	}

	public void setAptDate(String aptDate) {
		this.aptDate = aptDate;
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
	public int getAptPersonId() {
		return aptPersonId;
	}
	public void setAptPersonId(int aptPersonId) {
		this.aptPersonId = aptPersonId;
	}
	
	
	
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	
	
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	public boolean isAllDay() {
		return allDay;
	}

	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}

	public String getAppWith() {
		return appWith;
	}
	public void setAppWith(String appWith) {
		this.appWith = appWith;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public DigihealthCareSavePlanDetailsModel()
	{}
}
