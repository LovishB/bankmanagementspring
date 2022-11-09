package com.project.bankmanagement.entity;

import com.project.bankmanagement.util.BankEnums.PaymentType;

public class PaymentCredit extends Payment {

	public PaymentCredit(String account, String from_account, PaymentType direction, double amount) {
		this.account = account;
		this.from_account = from_account;
		super.direction = direction;
		this.amount = amount;
	}

	private String account;
	
	private String from_account;
	
	private double amount;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getFrom_account() {
		return from_account;
	}

	public void setFrom_account(String from_account) {
		this.from_account = from_account;
	}

	public PaymentType getDirection() {
		return direction;
	}

	public void setDirection(PaymentType direction) {
		this.direction = direction;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
