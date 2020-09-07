package com.calculator;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Calendar;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.sessions.SessionStorage;

public class DateCalculations {
	Scanner scan = new Scanner(System.in);
	SessionStorage session = new SessionStorage();

public void periodBetweenDates() {

	
	System.out.print("Enter First Date in format yyyy-mm-dd : ");  
	String dt= scan.next();
	LocalDate date=LocalDate.parse(dt);
	
	System.out.print("Enter Second Date in format yyyy-mm-dd : ");  
	String dt1= scan.next();
	LocalDate date1=LocalDate.parse(dt1);
			
	Period difference = Period.between(date,date1);
	
	System.out.printf("%d years, %d months"+ " and %d days ",difference.getYears(),difference.getMonths(),difference.getDays());
	
}

public void getDayofWeek() throws ClassNotFoundException, IOException {
	System.out.print("Enter First Date in format yyyy-mm-dd : ");  
	String dt= scan.next();
	LocalDate date=LocalDate.parse(dt);
	System.out.println(date.getDayOfWeek());
	session.writeArray(date);
	
}

public void getWeekForDay() throws ClassNotFoundException, IOException {
	Calendar calendar= Calendar.getInstance();
	System.out.print("Enter First Date in format yyyy-mm-dd : ");  
	String dt= scan.next();
	LocalDate date=LocalDate.parse(dt);
	Month month = date.getMonth();
	calendar.set(date.getYear(), month.getValue(), date.getDayOfMonth());
	System.out.println(Calendar.WEEK_OF_YEAR);
	session.writeArray(date);
}

public void addSubtractFromDate() throws ClassNotFoundException, IOException {
	
	System.out.print("Enter First Date in format yyyy-mm-dd : ");  
	String dt= scan.next();
	LocalDate date=LocalDate.parse(dt);
	System.out.println("\n1. Add Days \n2. Subtract Days \n3. Add Months \n4. Subtract Months \n5. Add Weeks \n6. Subtract Weeks \n7. Exit");
	
	System.out.print("\nSelect choice: ");
	int num = scan.nextInt();
	System.out.println("Enter the number to add or subtract");
	int number = scan.nextInt();
	LocalDate newDate = null;
	switch(num) {
	case 1:
		newDate = date.plusDays(number);
		break;
	case 2:
		newDate = date.minusDays(number);
		break;
	case 3:
		newDate = date.plusMonths(number);
		break;
	case 4:
		newDate = date.minusMonths(number);
		break;
	case 5:
		newDate = date.plusYears(number);
		break;
	case 6:
		newDate = date.minusYears(number);
		break;
		}
	session.writeArray(date);
	System.out.println("The new Date is "+newDate);
}

public void useNaturalLanguage() throws ClassNotFoundException, IOException {
		
		//Fetch Current date
		LocalDate date=LocalDate.now();
		
			System.out.print("Enter Phrase : ");  
			String str= scan.nextLine();
			
			StringTokenizer tokens = new StringTokenizer(str);
		    int count=tokens.countTokens();
		    String str1="";
		    int num=0;
		    
		    if(count>1) {
			String arr[] = str.split(" ", 2);
			str1=arr[1];
			num=Integer.parseInt(arr[0]);
			}
			
			if(str.equals("Today")) {
				System.out.println(date);
			}
			else if(str.equals("Yesterday")) {
				System.out.println(date.minusDays(1));
			}
			else if(str.equals("Tomorrow")) {
				System.out.println(date.plusDays(1));
			}
			else if(str.equals("Day-before-yesterday")) {
				System.out.println(date.minusDays(2));
			}
			else if(str.equals("Day-after-tomorrow")) {
				System.out.println(date.plusDays(2));
			}
			else if(str.equals("Last week")) {
				System.out.println(date.minusWeeks(1));
			}
			else if(str.equals("Next week")) {
				System.out.println(date.plusWeeks(1));
			}
			else if(str.equals("Last month")) {
				System.out.println(date.minusMonths(1));
			}
			else if(str.equals("Next month")) {
				System.out.println(date.plusMonths(1));
			}
			else if(str.equals("Last year")) {
				System.out.println(date.minusYears(1));
			}
			else if(str.equals("Next year")) {
				System.out.println(date.plusYears(1));
			}
			else if(str.equals("Last year")) {
				System.out.println(date.minusYears(1));
			}
			else if(str1.equals("days from now")) {
				System.out.println(date.plusDays(num));
			}
			else if(str1.equals("weeks from now")) {
				System.out.println(date.plusWeeks(num));
			}
			else if(str1.equals("months from now")) {
				System.out.println(date.plusMonths(num));
			}
			else if(str1.equals("years from now")) {
				System.out.println(date.plusYears(num));
			}
			else if(str1.equals("days earlier")) {
				System.out.println(date.minusDays(num));
			}
			else if(str1.equals("weeks earlier")) {
				System.out.println(date.minusWeeks(num));
			}
			else if(str1.equals("months earlier")) {
				System.out.println(date.minusMonths(num));
			}
			else if(str1.equals("years earlier")) {
				System.out.println(date.minusYears(num));
			}
		session.writeArray(date);
		
	
} 

}
