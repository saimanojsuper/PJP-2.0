package com.Implementation;

import java.util.ArrayList;
import java.util.List;

import com.BusinessLogic.ProcessingTransactions;
import com.POJO.TransactionPOJO;
import com.reader.CSVReader;
import com.reader.Reader;
import com.summary.Summary;



public class FeeProcessing {
	
	public static void main(String[] args) {
		List<TransactionPOJO> transactions = new ArrayList<TransactionPOJO>();
		Reader reader = new CSVReader();
		String filePath = "C:\\Users\\HP\\Desktop\\pjp2.0\\week2\\Assignment\\PS-PJP2_week2\\TransactionCalculator\\input.csv";
		transactions = reader.read(filePath);
		ProcessingTransactions transactionProcessing  = new ProcessingTransactions();
		transactions = transactionProcessing.processTransactionFee(transactions);
		Summary summary = new Summary();
		summary.generateReportSummary(transactions);
	}

}
