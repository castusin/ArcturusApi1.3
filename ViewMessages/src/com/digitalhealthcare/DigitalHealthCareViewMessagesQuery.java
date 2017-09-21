package com.digitalhealthcare;

public class DigitalHealthCareViewMessagesQuery {
	
	//public static final String SQL_VIEWMESSAGES ="SELECT A.User_id,A.Patient_id,A.Message_id,A.Apt_id,A.Message_text,A.phoneNumber,A.emailId,A.Create_date,A.Message_type, B.Apt_starttime,B.Apt_endtime,B.Type,B.Apt_with FROM Messages_table A  JOIN Appointments_table B ON A.Patient_id = B.Patient_id  WHERE A.Patient_id =? order by A.Create_date desc ";
	public static final String SQL_VIEWMESSAGES ="SELECT User_id,Patient_id,Message_id,Apt_id,Message_text,phoneNumber,emailId,Create_date,Message_type,Message_category FROM Messages_table   WHERE Patient_id =? order by Create_date desc ";
	//public static final String SQL_VIEWMESSAGES ="SELECT A.Message_id,A.Apt_id,A.Patient_id,A.phoneNumber,A.emailId,A.Message_text,A.Create_date,A.Message_type,A.Message_category,B.User_id,B.First_name,B.Last_name,B.Photo FROM Messages_table A  JOIN Profile_table B ON A.Patient_id = B.User_id and  A.Message_type='Sent Message'  WHERE A.Patient_id =? order by A.Create_date desc ";
}
