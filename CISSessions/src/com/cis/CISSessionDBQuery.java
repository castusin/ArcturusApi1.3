/**
 * 
 */
package com.cis;

/**
 * @author Darshan
 *
 */
public class CISSessionDBQuery {

	public static final String SQL_SESSION_TIME_CHECK = "select User_id,Session_id,Time_stamp,Delete_ind from Session_data where User_id=? and Session_id=? and Delete_ind=?";
	public static final String SQL_SESSION_TIME_UPDATE = "UPDATE Session_data set Time_stamp=? where User_id=? and Session_id=?";
}

