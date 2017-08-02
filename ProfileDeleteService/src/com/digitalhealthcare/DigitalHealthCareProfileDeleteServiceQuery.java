package com.digitalhealthcare;

public class DigitalHealthCareProfileDeleteServiceQuery {
	
	public static final String SQL_DELETEUSERDEVICE ="DELETE FROM User_Devices WHERE User_id=?";


	public static final String SQL_DELETEPATIENTFM ="DELETE FROM Patient_fm WHERE Patient_userid=?";


	public static final String SQL_DELETEPATIENTPHONE ="DELETE FROM Patient_phonenumber WHERE Patient_id=?";

	public static final String SQL_DELETEUSER ="DELETE FROM Profile_table WHERE User_id=?";

}
