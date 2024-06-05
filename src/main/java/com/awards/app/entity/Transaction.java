package com.awards.app.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Transaction {

	private String customerName;
	private int amount;
	private LocalDate transactionDate;
	private int rewardPoints;

	public Transaction(String customerName, int amount, LocalDate transactionDate, int rewardPoints) {
		super();
		this.customerName = customerName;
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.rewardPoints = rewardPoints;
	}

	public Transaction(String customerName, int amount, LocalDate transactionDate) {
		super();
		this.customerName = customerName;
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.rewardPoints = 0;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public int getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	
	@JsonIgnore
	public int getTransactionMonth() {
		return transactionDate.getMonthValue();
	}

}
