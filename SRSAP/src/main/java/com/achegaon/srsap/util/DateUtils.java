package com.achegaon.srsap.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * This is DateUtils for all utility function related to date
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 23-07-2017 $
 * 
 */

public class DateUtils {
	
	public java.sql.Timestamp createCurrentTimestamp() {
        Calendar c = Calendar.getInstance();
        return new java.sql.Timestamp(c.getTimeInMillis());         
    }
	
	public java.sql.Date convertStringToSqlDate(String date) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date sqlDate = null;
		try {
			java.util.Date d = sdf1.parse(date);
			sqlDate = new java.sql.Date(d.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sqlDate;
	}
	
	public java.sql.Timestamp convertStringToSqlTimestamp(String timestamp) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		java.sql.Timestamp sqlTimestamp = null;
		try {
			java.util.Date d = sdf1.parse(timestamp);
			sqlTimestamp = new java.sql.Timestamp(d.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sqlTimestamp;
	}

}
