package com.java.se;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class VisulaCalander {

	public static void main(String[] args) {
		System.out.println("请输入你期望的日期：");
		/*Scanner c = new Scanner(System.in);
		String strDate = c.next();*/
		printCalander("2013-11-05","yyyy-MM-dd");
	}
	
	public static void printCalander(String strDate, String dateFormat) {
		try {
			System.out.print("星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六");
			Calendar calender = new GregorianCalendar();
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			Date date = sdf.parse(strDate);
			calender.setTime(date);
			//设置这个月的第一天,星期天是1
			calender.set(Calendar.DATE, 1);
			int day_of_week = calender.get(Calendar.DAY_OF_WEEK);
			//本月最大数
			int max_day_of_month = calender.getActualMaximum(Calendar.DATE);
			//错误:int max_day_of_month2 = calender.getMaximum(Calendar.DATE);
			
			int j = 0;
			for(int i=0; i<max_day_of_month + 1; i++) {
				if(j <= day_of_week - 1) {
					System.out.print("\t");
					i = 0;
				} else {
					if(i == day_of_week) {
						System.out.print(" *"+(i+1) +" ");
						System.out.print("\t");
					} else {
						System.out.print(" "+(i+1) +" ");
						System.out.print("\t");
					}
				}
				if(j%7 == 0) {
					System.out.println("");
				}
				j++;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
