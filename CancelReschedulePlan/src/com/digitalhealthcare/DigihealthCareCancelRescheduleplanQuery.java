package com.digitalhealthcare;

public class DigihealthCareCancelRescheduleplanQuery {
	
	public static final String SQL_CANCELRESCHEDULEPLAN = "insert into Messages_table (Message_id,Apt_id,Patient_id,User_id,phoneNumber,emailId,Message_text,Create_date,Message_type,Message_category)"+"values(?,?,?,?,?,?,?,?,?,?)";
	
	
	public static final String SQL_GETPATIENTDETAILS = "SELECT A.Apt_starttime, A.Type, A.Apt_with, P.First_name, P.Last_name,P.Email_id FROM Appointments_table A JOIN Profile_table P ON A.Patient_id = P.User_id WHERE A.Apt_id = ?";

}
