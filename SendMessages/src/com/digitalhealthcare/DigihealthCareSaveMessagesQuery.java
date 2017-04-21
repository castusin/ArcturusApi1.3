package com.digitalhealthcare;

public class DigihealthCareSaveMessagesQuery {
	
	public static final String SQL_SENDMESSAGES = "select Apt_id,Patient_id,User_id,phoneNumber,emailId,Message_text,Create_date from Messages_table where Patient_id=?";


}
