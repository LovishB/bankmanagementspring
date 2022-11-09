package com.project.bankmanagement.entity;

public class PaymentRequest {
	
	private double amount;
	
	private String to_account;
	
	private String from_account;
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getFrom_account() {
		return from_account;
	}

	public void setFrom_account(String from_acoount) {
		this.from_account = from_acoount;
	}

	public String getTo_account() {
		return to_account;
	}

	public void setTo_account(String to_account) {
		this.to_account = to_account;
	}

}
