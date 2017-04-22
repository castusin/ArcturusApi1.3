package com.digitalhealthcare;

public class DigihealthCareRescheduleQuery {
	
	//public static final String SQL_RESCHEDULEPLAN = "insert into Messages_table (Message_id,Apt_id,Patient_id,User_id,phoneNUmber,emailId,Message_text,Create_date)"+"values(?,?,?,?,?,?,?,?)";

	public static final String SQL_RESCHEDULEPLAN = "update Messages_table  set Apt_id=?,User_id=?,Message_text=? where Patient_id=?";

}
