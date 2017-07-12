
package com.digitalhealthcare;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author 
 *
 */
@SuppressWarnings("rawtypes")
public class DigihealthCareSaveMessagesMapper implements RowMapper{
public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	DigihealthCareSaveMessagesModel saveMessages = new DigihealthCareSaveMessagesModel();
	   
	     
	     saveMessages.setAptId(rs.getString("Apt_id"));
	     saveMessages.setPatientId(rs.getString("Patient_id"));
	     saveMessages.setUserId(rs.getString("User_id"));
	     //saveMessages.setPhoneNumber(rs.getInt("phoneNumber"));
	    // saveMessages.setEmailId(rs.getString("emailId"));
	     saveMessages.setMessageText(rs.getString("Message_text"));
	     saveMessages.setCreateDate(rs.getDate("Create_date"));
	     
	     
		return saveMessages;
	}
}
