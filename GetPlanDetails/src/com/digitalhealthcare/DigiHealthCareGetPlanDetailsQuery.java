/**
 * 
 */
package com.digitalhealthcare;

/**
 * @author 
 *
 */
public class DigiHealthCareGetPlanDetailsQuery {

	public static final String SQL_PLANSDATA = "select Apt_id,Apt_person_id,Patient_id,Apt_starttime,Apt_endtime,Total_day,Type,Apt_with from Appointments_table where Patient_id=?";

	//public static final String SQL_PLANSDATA = "select A.Apt_id,A.Apt_person_id,A.Patient_id,A.Apt_starttime,A.Apt_endtime,A.Total_day,A.Type,A.Apt_with ,B.User_id from Appointments_table A Join Profile_table B  where A.Patient_id=? or B.User_id=?";

}
