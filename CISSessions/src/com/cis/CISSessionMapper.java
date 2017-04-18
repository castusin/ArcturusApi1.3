/**
 * 
 */
package com.cis;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * @author Darshan
 *
 */
@SuppressWarnings("rawtypes")
public class CISSessionMapper implements RowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		CISSessionModel digiSession = new CISSessionModel();	
		digiSession.setUserId(rs.getString("User_id"));
		digiSession.setSessionId(rs.getString("Session_id"));
		digiSession.setTimeStamp(rs.getString("Time_stamp"));
		digiSession.setDeleteInd(rs.getString("Delete_ind"));
		return digiSession;
	}


}
