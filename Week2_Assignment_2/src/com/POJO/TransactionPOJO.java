package com.POJO;

import java.util.Date;

public class TransactionPOJO {
	
	private String externalTransactionId;
	private String clientId;
	private String securityId;
	private String transactionType;
	private Date transactionDate;
	private double marketValue;
	private char priorityFlag;
	private double feeProceesed;
	
	public TransactionPOJO(String externalTransactionId, String clientId, String securityId, String transactionType,
			Date transactionDate, double marketValue, char priorityFlag) {
		super();
		this.externalTransactionId = externalTransactionId;
		this.clientId = clientId;
		this.securityId = securityId;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.marketValue = marketValue;
		this.priorityFlag = priorityFlag;
	}
	public String getExternalTransactionId() {
		return externalTransactionId;
	}
	public void setExternalTransactionId(String externalTransactionId) {
		this.externalTransactionId = externalTransactionId;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getSecurityId() {
		return securityId;
	}
	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public double getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(double marketValue) {
		this.marketValue = marketValue;
	}
	public char getPriorityFlag() {
		return priorityFlag;
	}
	public void setPriorityFlag(char priorityFlag) {
		this.priorityFlag = priorityFlag;
	}
	public double getFeeProceesed() {
		return feeProceesed;
	}
	public void setFeeProceesed(double feeProceesed) {
		this.feeProceesed = feeProceesed;
	}
	
	

}
