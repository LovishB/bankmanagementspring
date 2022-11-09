package com.project.bankmanagement.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Repository;

import com.project.bankmanagement.entity.Account;

@Repository
public class AccountRepository {

	private Map<String, Account> allAccounts = new HashMap<String, Account>();

	public List<Account> getAllAccountsList() {
		List<Account> allAccountList = new ArrayList<>();
		for(Entry<String, Account> account :  allAccounts.entrySet()) {
			allAccountList.add(account.getValue());
		}
		return allAccountList;
	}

	public void setAllAccounts(Map<String, Account> allAccounts) {
		this.allAccounts = allAccounts;
	}
	
	public Account getAcount(String id) {
		return allAccounts.get(id);
	}
	
	public  Map<String, Account> getAllAccount() {
		return allAccounts;
	}
	
	public void updateAccountBalance(String id, double amount) {
		allAccounts.get(id).setBalance(amount);
	}
	
	public double getAccountBalance(String id) {
		return allAccounts.get(id).getBalance();
	}
		
}
