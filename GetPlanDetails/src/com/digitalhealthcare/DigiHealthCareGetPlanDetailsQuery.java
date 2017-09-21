/**
 * 
 */
package com.digitalhealthcare;

/**
 * @author 
 *
 */
public class DigiHealthCareGetPlanDetailsQuery {

	//public static final String SQL_PLANSDATA = "select Apt_id,Apt_person_id,Patient_id,Apt_starttime,Apt_endtime,Total_day,Type,Apt_with from Appointments_table where Patient_id=? order by Apt_starttime desc ";

	public static final String SQL_PLANSDATA = "select Apt_id,Apt_person_id,Patient_id,Apt_starttime,Apt_endtime,Total_day,Type,Apt_with from Appointments_table where Patient_id=? order by STR_TO_DATE(Apt_starttime, '%a %b %d %Y %T') asc";
}
