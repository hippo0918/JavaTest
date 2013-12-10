package com.java.se;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestDate {

	public static void main(String[] args) {
		Calendar c = new GregorianCalendar();
		SimpleDateFormat dateFormatFromDate = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat dateFormatToDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			String date = "20120520";
			Date d = new Date();
			String s = dateFormatToDate.format(d);
			System.out.println(s);
			Date d1 = dateFormatFromDate.parse(date);
			System.out.println(dateFormatToDate.format(d1));
			//System.out.println(d);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.set(2013, c.OCTOBER, 13, 23, 32, 00);
		System.out.println(dateFormatToDate.format(c.getTime()));
		System.out.println(c.getTimeInMillis());
		System.out.println(c.get(c.DATE));
		System.out.println(c.get(c.DAY_OF_MONTH));
		System.out.println(c.get(c.DAY_OF_WEEK));
		System.out.println(c.get(c.DAY_OF_WEEK_IN_MONTH));
		System.out.println(c.get(c.DAY_OF_YEAR));
		System.out.println(c.get(c.AM));
		System.out.println(c.get(c.ERA));
		System.out.println(c.get(c.HOUR));
		System.out.println(c.get(c.HOUR_OF_DAY));
	}
}
