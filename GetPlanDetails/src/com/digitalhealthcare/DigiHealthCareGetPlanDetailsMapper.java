/**
 * 
 */
package com.digitalhealthcare;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author 
 *
 */
@SuppressWarnings("rawtypes")
public class DigiHealthCareGetPlanDetailsMapper implements RowMapper{
public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	DigihealthCareSavePlanDetailsModel planModel = new DigihealthCareSavePlanDetailsModel();
	     planModel.setAptId(rs.getString("Apt_id"));
	     planModel.setAptPersonId(rs.getInt("Apt_person_id"));
	     planModel.setPatientId(rs.getString("Patient_id"));
	     planModel.setStartTime(rs.getString("Apt_starttime"));
		 planModel.setEndTime(rs.getString("Apt_endtime"));
		 planModel.setAllDay(rs.getBoolean("Total_day"));
		 planModel.setTitle(rs.getString("Type"));
		 planModel.setAppWith(rs.getString("Apt_with"));
		// planModel.setCreateDate(rs.getDate("Create_date"));
	    // planModel.setAptDate(rs.getString("Date_time"));
		
		
		return planModel;
	}
}
