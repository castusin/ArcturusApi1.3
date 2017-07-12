package com.digitalhealthcare;

public class DigitalHealthCareViewMessagesQuery {
	
	public static final String SQL_VIEWMESSAGES ="SELECT A.User_id,A.Patient_id,A.Message_id,A.Apt_id,A.Message_text,A.phoneNumber,A.emailId,A.Create_date, B.Apt_starttime,B.Apt_endtime,B.Type,B.Apt_with FROM Messages_table A  JOIN Appointments_table B ON A.Apt_id = B.Apt_id  WHERE A.Patient_id =? and A.User_id=? ";

}
