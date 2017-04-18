package com.cis;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class TimeCheck {
	
	public String getTimeZone() {
		
		Calendar current = Calendar.getInstance();
	    DateFormat formatterTime = new SimpleDateFormat(CISConstants.DATE_FORMAT);
	    TimeZone objTime = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
	    formatterTime.setTimeZone( objTime);
	    String serviceTime=formatterTime.format(current.getTime());
		return serviceTime;
	}

}
