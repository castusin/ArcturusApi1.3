package com.cis;

public class CISSessionModel {
	public String userId;
	public String sessionId;
	public String timeStamp;
	public String deleteInd;
	
	
	public String getDeleteInd() {
		return deleteInd;
	}

	public void setDeleteInd(String deleteInd) {
		this.deleteInd = deleteInd;
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
	
public CISSessionModel(String userId, String sessionId,
			String timeStamp, String deleteInd) {
		super();
		this.userId = userId;
		this.sessionId = sessionId;
		this.timeStamp = timeStamp;
		this.deleteInd = deleteInd;
	}

public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

public CISSessionModel(){
		
	}
}
