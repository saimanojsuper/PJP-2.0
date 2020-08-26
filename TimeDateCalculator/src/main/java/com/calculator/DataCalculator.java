package com.calculator;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import com.sessions.SessionStorage;


public class DataCalculator {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n1. Add and Subtract Dates \n2. Add and Subtract n factor \n3. Day of week \n4. Week Number \n5. Natural Language Phrases \n6. Exit");
		System.out.print("\nSelect choice: ");
		SessionStorage session = new SessionStorage();
		int num = scan.nextInt();
		DateCalculations dateCalculation = new DateCalculations();
           
		    while(num!=0) {
			switch(num) {
				case 1:
					dateCalculation.periodBetweenDates();
					break;
				case 2:
					dateCalculation.addSubtractFromDate();
					break;
				case 3:
					dateCalculation.getDayofWeek();
				 	break;
				case 4:
					dateCalculation.getWeekForDay();
					break;
				case 5:
					dateCalculation.useNaturalLanguage();
					break;
					}
			System.out.println("\n1. Add and Subtract Dates \n2. Add and Subtract n factor \n3. Day of week \n4. Week Number \n5. Natural Language Phrases \n6. Exit");
			System.out.print("\nSelect choice: ");
			num = scan.nextInt();
		
		    }
		    
		    session.read();
		    session.write();
			session.displaySession();
}
	
}
