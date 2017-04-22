/**
 * 
 */
package com.digitalhealthcare;

/**
 * @author Darshan
 *
 */
public class DigiHealthCareGetPlanDetailsQuery {

	public static final String SQL_PLANSDATA = "select Apt_id,Apt_person_id,Patient_id,Apt_starttime,Apt_endtime,Total_day,Type,Apt_with from Appointments_table where Patient_id=?";

}
