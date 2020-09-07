package com.BusinessLogic;

import java.util.ArrayList;
import java.util.List;

import com.POJO.TransactionPOJO;


public class ProcessingTransactions {
	private int processingFees;
	private List<TransactionPOJO> transactions = new ArrayList<TransactionPOJO>();
	FeePerTransaction feeForTransaction = new FeePerTransaction();
	
	public List<TransactionPOJO> processTransactionFee(List<TransactionPOJO> transactions) {
		for(TransactionPOJO transaction : transactions ) {
			if(isTransactionIntraDay(transaction)) {
				processIntraTransaction(transaction);
			} else {
				processNormalTransactions(transaction);
			}
		}
		return transactions;
	}
	

	
	private void processNormalTransactions(TransactionPOJO transaction) {
		if(transaction.getPriorityFlag()=='Y') {
			processingFees = 500;
		} else {
			FeePerTransaction feeForTransactions = new FeePerTransaction();
			processingFees = feeForTransactions.getFeePerTransaction(transaction.getTransactionType());
		}
		transaction.setFeeProceesed(processingFees);
	}

	private void processIntraTransaction(TransactionPOJO transaction) {
		int fees = 10;
		transaction.setFeeProceesed(processingFees);
	}
	
	private boolean isTransactionIntraDay(TransactionPOJO transaction) {
		boolean isIntraDay = false;
		if (transactions.size() > 0) {
			TransactionPOJO temp = null;
			for (TransactionPOJO transactionf : transactions) {
				if (transactionf.getClientId().equals(transactionf.getClientId())
						&& transactionf.getSecurityId().equals(transactionf.getSecurityId())
						&& transactionf.getTransactionDate().equals(transactionf.getTransactionDate())) {
					if ((transactionf.getTransactionType().contentEquals("BUY") 
							&& transactionf.getTransactionType().contentEquals("SELL"))
							|| (transactionf.getTransactionType().contentEquals("SELL")
									&& transactionf.getTransactionType().contentEquals("BUY"))) {
						isIntraDay = true;
						temp = transactionf;
						break;
					}
				}
			}

			if (temp != null) {
				transactions.remove(temp);
				temp.setFeeProceesed(temp.getFeeProceesed()+feeForTransaction.getFeePerTransaction(temp.getTransactionType()));
				transactions.add(temp);
			}

		} else {
			isIntraDay = false;
		}
		return isIntraDay;
	}
	

}
