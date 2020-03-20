package com.mt.rideshare.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CommonUtil {
	public static Date convertStringToDate(String dateTime) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date convertedDate = null;
		try {
			convertedDate = simpleDateFormat.parse(dateTime);
		} catch (ParseException ex) {

		}
		return convertedDate;
	}
	public static Date getAdjustedDateByMinute(Date dateTime,int adjustedMinute){
		  Calendar calendar = Calendar.getInstance();
		  calendar.setTime(dateTime);
		  calendar.add(Calendar.MINUTE, adjustedMinute);
		  return calendar.getTime();
	}
	public static String convertDateToString(Date inputDate){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return simpleDateFormat.format(inputDate);
	}
}
