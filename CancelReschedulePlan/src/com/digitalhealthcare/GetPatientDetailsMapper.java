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
public class GetPatientDetailsMapper implements RowMapper{
public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	
	GetPatientDetailsModel planModel = new GetPatientDetailsModel();
	     planModel.setPatientFname(rs.getString("First_name"));
	     planModel.setPatientLname(rs.getString("Last_name"));
	     planModel.setAptWith(rs.getString("Apt_with"));
	     planModel.setStartTime(rs.getString("Apt_starttime"));
		 planModel.setServicetype(rs.getString("Type"));
		 planModel.setEmailid(rs.getString("Email_id"));
	
		return planModel;
	}
}
