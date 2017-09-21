
package com.digitalhealthcare;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author 
 *
 */
public class GetPatientDetailsModel {
	
	
	public String patientFname;
	public String patientLname;
	public String aptWith;
	public String servicetype;
	public String startTime;
	public String emailid;
	public GetPatientDetailsModel(String patientFname, String patientLname, String staffFname, String staffLname, String servicetype, String aptWith, String startTime, String emailid) {
		super();
		this.patientFname = patientFname;
		this.patientLname = patientLname;
		this.aptWith = aptWith;
		this.startTime = startTime;
		this.servicetype = servicetype;
		this.emailid=emailid;
	}
	
	


	public String getEmailid() {
		return emailid;
	}




	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}




	public String getPatientFname() {
		return patientFname;
	}




	public void setPatientFname(String patientFname) {
		this.patientFname = patientFname;
	}




	public String getPatientLname() {
		return patientLname;
	}




	public void setPatientLname(String patientLname) {
		this.patientLname = patientLname;
	}




	
	public String getAptWith() {
		return aptWith;
	}




	public void setAptWith(String aptWith) {
		this.aptWith = aptWith;
	}




	public String getStartTime() {
		return startTime;
	}




	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}




	public String getServicetype() {
		return servicetype;
	}




	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
	}




	public GetPatientDetailsModel()
	{}
}
