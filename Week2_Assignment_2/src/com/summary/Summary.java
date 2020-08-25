package com.summary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.POJO.TransactionPOJO;


public class Summary {
	
	public void generateReportSummary(List<TransactionPOJO> transactions) {
	
        Collections.sort(transactions,Comparator.comparing((TransactionPOJO trans) -> trans.getClientId()).
        		thenComparing((TransactionPOJO trans) -> trans.getTransactionType())
        		.thenComparing((TransactionPOJO trans) -> trans.getTransactionDate())
        		.thenComparing((TransactionPOJO trans) -> trans.getPriorityFlag()));
 
        
        
        System.out.println("Client Id \tTransaction Type \tTransaction Date \t\t    Priority \t\tProcessing Fee");
        for (TransactionPOJO transaction : transactions) {
        	//System.out.println(transaction.getTransactionType());
        	if(!transaction.getTransactionType().equals("WITHDRAW")) {
        		System.out.println(transaction.getClientId() + "\t\t" + transaction.getTransactionType() +
                		"\t\t\t" +
                        transaction.getTransactionDate() + "\t\t" + transaction.getPriorityFlag() + 
                        "\t\t" +
                        transaction.getFeeProceesed() + "\t\t");
        		
        	}
        	else {
            System.out.println(transaction.getClientId() + "\t\t" + transaction.getTransactionType() +
            		"\t\t" +
                    transaction.getTransactionDate() + "\t\t" + transaction.getPriorityFlag() + 
                    "\t\t" +
                    transaction.getFeeProceesed() + "\t\t");
        	}
        }
	}

}
