package oop.task2;

import java.util.Calendar;

public class TimeDate {
	private int hour;
	private int minute;
	private int second;
	private int day;
	private int month;
	private int year;
	private Calendar calendar;
	
	public TimeDate(){
		this.calendar = Calendar.getInstance();
		this.hour = calendar.get(Calendar.HOUR_OF_DAY);
		this.minute = calendar.get(Calendar.MINUTE);
		this.second = calendar.get(Calendar.SECOND);
		this.day = calendar.get(Calendar.DAY_OF_MONTH);
		this.month = calendar.get(Calendar.MONTH) + 1;
		this.year = calendar.get(Calendar.YEAR);
	}
	
	public TimeDate(int h) {
		setTime(h, 0, 0);
	}
	
	public TimeDate(int h, int m) {
		setTime(h, m, 0);
	}
	
	public TimeDate(int h, int m, int s) {
		setTime(h, m, s);
	}
	
	public TimeDate(int h, int m, int s, int d) {
		setTimeDate(h, m, s, d, 1, 1);
	}
	
	public TimeDate(int h, int m, int s, int d,int mm) {
		setTimeDate(h, m, s, d, mm, 1);
	}
	
	public TimeDate(int h, int m, int s, int d, int mm, int y) {
		setTimeDate(h, m, s, d, mm, y);
	}
	
	public void setTimeDate(int h, int m, int s, int d, int mm, int y) {
		setTime(h, m, s);
		setData(d, mm, y);
	}
	
	public void setTime(int h, int m, int s) {
		hour = (h >= 0 && h < 24)? h : -1;
		minute = (m >= 0 && m < 60) ? m : -1;
		second = (s >= 0 && s < 60)? s : -1;
	}
	
	public void setData(int d, int mm, int y) {
		if (mm == 2 && y % 2 == 0) 
			day = (d > 0 && d <= 28)? d : -1;
		else if (mm == 2)
			day = (d > 0 && d <= 29)? d : -1;
		else if ((mm % 2 != 0 && mm <= 8) || (mm % 2 == 0 && mm >= 8))
			day = (d > 0 && d <= 31)? d : -1;
		else
			day = (d > 0 && d <= 30)? d : -1;
			month = (mm > 0 && mm <= 12)? mm : -1;
			year = (y >= 0 && y <= 2015)? y : -1; 
	}
	
	public int getHour() {
		return hour;
	}
	
	public int getMinute() {
		return minute;
	}
	
	public int getSecond() {
		return second;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	public static TimeDate timeNow() {
		return new TimeDate();
	}
	
	public String getTime() {
		return toString();
	}
	
	@Override
	public String toString() {
		return String.format("%02d:%02d:%02d %02d.%02d.%04d",getHour(), getMinute(), getSecond(), getDay(), getMonth(), getYear());
	}
	
	
	
}
