package com.BusinessLogic;

import java.util.HashMap;
import java.util.Map;

public class FeePerTransaction {
	
	private Map<String,Integer> type = new HashMap<String,Integer>();
	public FeePerTransaction() {
		type.put("BUY",0); 
		type.put("SELL",1); 
		type.put("DEPOSIT",2); 
		type.put("WITHDRAW",3); 
	}
	
	public int getFeePerTransaction(String transactionType) {
		int val = type.get(transactionType);
		
		if(val == 0) return 50;
		else if( val == 1) return 100;
		else if(val == 2) return 50;
		return 100;
		
	}

}
