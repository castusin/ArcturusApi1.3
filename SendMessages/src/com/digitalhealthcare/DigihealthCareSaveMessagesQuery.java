package com.digitalhealthcare;

public class DigihealthCareSaveMessagesQuery {
	
	public static final String SQL_SENDMESSAGES = "insert into Messages_table (Message_id,Apt_id,Patient_id,User_id,phoneNumber,emailId,Message_text,Create_date,Message_type,Message_category)"+"values(?,?,?,?,?,?,?,?,?,?)";


}
