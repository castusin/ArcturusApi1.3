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

	public int aptId;
	public String userId;
	public int aptPersonId;
	public String type;
	public String appWith;
	public String status;
	public Timestamp aptDate;
	public Date createDate;
	
	
	
	
	public DigihealthCareSavePlanDetailsModel(int aptId, String userId,
			int aptPersonId, String type, String appWith, String status,
			Timestamp aptDate, Date createDate) {
		super();
		this.aptId = aptId;
		this.userId = userId;
		this.aptPersonId = aptPersonId;
		this.type = type;
		this.appWith = appWith;
		this.status = status;
		this.aptDate = aptDate;
		this.createDate = createDate;
	}
	public Timestamp getAptDate() {
		return aptDate;
	}
	public void setAptDate(Timestamp aptDate) {
		this.aptDate = aptDate;
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
	public int getAptPersonId() {
		return aptPersonId;
	}
	public void setAptPersonId(int aptPersonId) {
		this.aptPersonId = aptPersonId;
	}
	public String getType() {
		return type;
	}
	
	
	
	public void setType(String type) {
		this.type = type;
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
