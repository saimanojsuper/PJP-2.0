package com.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.POJO.TransactionPOJO;

public class CSVReader implements Reader {
	
	private List<TransactionPOJO> transactions = new ArrayList<>();

	@Override
	public List<TransactionPOJO> read(String filePath) {
		BufferedReader br=null;
		String data;
		try {
			br = new BufferedReader(new FileReader(filePath));	
			//System.out.println(br.readLine());
            while ((data = br.readLine()) != null) {
            	String[] transaction = data.split(","); 
                String externalTransactionId = transaction[0];
            	String clientId = transaction[1];
            	String securityId = transaction[2];
            	String transactionType= transaction[3];
            	Date transactionDate = new SimpleDateFormat("MM/dd/yyyy").parse(transaction[4]);
            	double marketValue = Double.parseDouble(transaction[5]);
            	char priorityFlag = transaction[5].charAt(0);
            	TransactionPOJO t = new TransactionPOJO(externalTransactionId,clientId,securityId,transactionType, transactionDate,marketValue,priorityFlag);
            	//System.out.println(t);
                transactions.add(t);
            }
		} catch (FileNotFoundException | ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			try {
				br.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		
		return transactions;
	}

}
