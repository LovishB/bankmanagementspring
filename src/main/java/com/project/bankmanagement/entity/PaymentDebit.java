package com.project.bankmanagement.entity;

import com.project.bankmanagement.util.BankEnums.PaymentType;

public class PaymentDebit extends Payment {
	
	public PaymentDebit(String account, String to_account, PaymentType direction, double amount) {
		this.account = account;
		this.to_account = to_account;
		super.direction = direction;
		this.amount = amount;
	}

	private String account;
	
	private String to_account;
	
	private double amount;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getTo_account() {
		return to_account;
	}

	public void setTo_account(String to_account) {
		this.to_account = to_account;
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
