package com.prac;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class DateTime {

	public static void main(String[] args) {
		
		LocalDate date = LocalDate.of(2000,1,13);
		System.out.println(date);
		
		LocalTime t = LocalTime.now();
		System.out.println(t);
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		
		 DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		  System.out.println(ldt.format(f));
		  
		  Scanner sc = new Scanner(System.in);
		  
		  
//		  System.out.println("Enter date");
//		  String s = sc.nextLine();
//		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//		  //java default format for date time is yyyy-MM-dd so If input is is this format we dont need to pass the formatter in the parse otherwise.
//		  LocalDate d = LocalDate.parse(s,formatter);
//		  System.out.println(d.format(formatter));
		  
		  
		  
		  LocalDate today = LocalDate.now();

		  LocalDate nextWeek = today.plusDays(7);
		  LocalDate lastMonth = today.minusMonths(1);
		  System.out.println(nextWeek);
		  System.out.println(lastMonth);


		  

	        LocalDate start = LocalDate.of(2020, 1, 10);
	        LocalDate end = LocalDate.of(2026, 2, 15);

	        Period p = Period.between(start, end);
	        
	        System.out.println(p.getYears());
	        System.out.println(p.getMonths());
	        System.out.println(p.getDays());
	        
	        //to check is leap year or not
	        LocalDate dat = LocalDate.of(2000,1,13);
	        System.out.println(dat.isLeapYear());
	        
	        
	        LocalDate start1 = LocalDate.of(2020, 1, 10);
	        LocalDate end1 = LocalDate.of(2026, 2, 15);

	        long days = ChronoUnit.DAYS.between(start1, end1);
	        long months = ChronoUnit.MONTHS.between(start, end);
	        long years = ChronoUnit.YEARS.between(start, end);
	        System.out.println(days);
	        System.out.println(months);
	        System.out.println(years);
	        
	        String s = "2028";
	        Year y = Year.parse(s);
	        System.out.println(y);
	        
	        LocalDate start2 = y.atDay(1);
	        LocalDate end2 = y.atMonth(12).atEndOfMonth();

	        System.out.println(start2);
	        System.out.println(end2);
	        
	        
	        
	        LocalDate date1 = LocalDate.of(2026, 2, 15);

	        DayOfWeek day = date1.getDayOfWeek();
	        System.out.println(day);
	        
	        Month month = date1.getMonth();
	        System.out.println(month);
	        
	        
	        
	        
	        LocalDateTime datw3 = LocalDateTime.of(2026, 2, 15, 18, 45, 30);


            System.out.println("d  (day of month)            : " + datw3.format(DateTimeFormatter.ofPattern("d")));
            System.out.println("dd (day of month)            : " + datw3.format(DateTimeFormatter.ofPattern("dd")));
            System.out.println("D  (day of year)             : " + datw3.format(DateTimeFormatter.ofPattern("D")));
            System.out.println("DD (day of year)             : " + datw3.format(DateTimeFormatter.ofPattern("DD")));
            System.out.println("E  (day name short)          : " + datw3.format(DateTimeFormatter.ofPattern("E")));
            System.out.println("EEE(day name short)          : " + datw3.format(DateTimeFormatter.ofPattern("EEE")));
            System.out.println("EEEE(day name full)          : " + datw3.format(DateTimeFormatter.ofPattern("EEEE")));

            System.out.println("M  (month number)            : " + datw3.format(DateTimeFormatter.ofPattern("M")));
            System.out.println("MM (month number)            : " + datw3.format(DateTimeFormatter.ofPattern("MM")));
            System.out.println("MMM(month short name)        : " + datw3.format(DateTimeFormatter.ofPattern("MMM")));
            System.out.println("MMMM(month full name)        : " + datw3.format(DateTimeFormatter.ofPattern("MMMM")));

            System.out.println("yy (2-digit year)            : " + datw3.format(DateTimeFormatter.ofPattern("yy")));
            System.out.println("yyyy(full year)              : " + datw3.format(DateTimeFormatter.ofPattern("yyyy")));

            System.out.println("H  (hour 0-23)               : " + datw3.format(DateTimeFormatter.ofPattern("H")));
            System.out.println("HH (hour 00-23)              : " + datw3.format(DateTimeFormatter.ofPattern("HH")));
            System.out.println("h  (hour 1-12)               : " + datw3.format(DateTimeFormatter.ofPattern("h")));
            System.out.println("hh (hour 01-12)              : " + datw3.format(DateTimeFormatter.ofPattern("hh")));
            System.out.println("a  (AM/PM)                   : " + datw3.format(DateTimeFormatter.ofPattern("a")));

            System.out.println("m  (minute)                  : " + datw3.format(DateTimeFormatter.ofPattern("m")));
            System.out.println("mm (minute)                  : " + datw3.format(DateTimeFormatter.ofPattern("mm")));
            System.out.println("s  (second)                  : " + datw3.format(DateTimeFormatter.ofPattern("s")));
            System.out.println("ss (second)                  : " + datw3.format(DateTimeFormatter.ofPattern("ss")));

            System.out.println("dd-MM-yyyy                   : " + datw3.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            System.out.println("yyyy-MM-dd                   : " + datw3.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            System.out.println("EEEE, dd MMMM yyyy           : " + datw3.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy")));
            System.out.println("dd MMM yyyy                  : " + datw3.format(DateTimeFormatter.ofPattern("dd MMM yyyy")));
            System.out.println("hh:mm a                      : " + datw3.format(DateTimeFormatter.ofPattern("hh:mm a")));
            System.out.println("HH:mm:ss                     : " + datw3.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
            System.out.println("dd-MM-yyyy HH:mm:ss          : " + datw3.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
            System.out.println("EEEE MMMM                    : " + datw3.format(DateTimeFormatter.ofPattern("EEEE MMMM")));
	    }

		  
	}


