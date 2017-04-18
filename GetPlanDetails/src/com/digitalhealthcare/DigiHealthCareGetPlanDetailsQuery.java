/**
 * 
 */
package com.digitalhealthcare;

/**
 * @author Darshan
 *
 */
public class DigiHealthCareGetPlanDetailsQuery {

	public static final String SQL_PLANSDATA = "select Apt_id,User_id,Apt_person_id,Date_time,Type,Apt_with from Appointments_table where User_id=?";

}
