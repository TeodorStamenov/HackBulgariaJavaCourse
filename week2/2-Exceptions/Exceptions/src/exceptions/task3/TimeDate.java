package exceptions.task3;

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
		if (h >= 0 && h < 24) {
			hour = h;
		} else {
			throw new IllegalArgumentException("Invalid hour");			
		}
		if (m >= 0 && m < 60) {
			minute = m;
		} else {
			throw new IllegalArgumentException("Invalid minute");
		} 
		if (s >= 0 && s < 60) {
			second = s;
		} else 
			throw new IllegalArgumentException("Invalid second");
	}
	
	public void setData(int d, int mm, int y) {
		if (mm == 2 && y % 2 == 0) {
			if (d > 0 && d <= 28)
				day = d;
			else 
				throw new IllegalArgumentException("Invalid day");
		}
		else if (mm == 2) {
			if (d > 0 && d <= 29)
				day = d;
			else 
				throw new IllegalArgumentException("Invalid day");
		}
		else if ((mm % 2 != 0 && mm <= 8) || (mm % 2 == 0 && mm >= 8)) {
			 if (d > 0 && d <= 31)
				 day = d;
			 else
				 throw new IllegalArgumentException("Invalid day");
		}
		else if (d > 0 && d <= 30)
			day = d;
		else 
			throw new IllegalArgumentException("Invalid day");
		
		if (mm > 0 && mm <= 12)
			month = mm; 
		else 
			throw new IllegalArgumentException("Invalid month");
		
		if (y >= 0 && y <= 2015)
			year = y;
		else 
			throw new IllegalArgumentException("Invalid year");
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
	
	@Override
	public String toString() {
		return String.format("%02d:%02d:%02d %02d.%02d.%04d",getHour(), getMinute(), getSecond(), getDay(), getMonth(), getYear());
	}
	
	
	
}
