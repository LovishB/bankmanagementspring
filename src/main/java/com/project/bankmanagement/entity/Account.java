package com.project.bankmanagement.entity;

import com.project.bankmanagement.util.BankEnums.Currency;

public class Account {

	private String id;
	
	private String owner;
	
	private double balance;
	
	private Currency currency;
	
	public Account(String id, String owner, double balance, Currency currency) {
		this.id = id;
		this.owner = owner;
		this.balance = balance;
		this.currency = currency;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
}
