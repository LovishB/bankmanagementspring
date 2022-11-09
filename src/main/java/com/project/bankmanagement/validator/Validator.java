package com.project.bankmanagement.validator;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.bankmanagement.entity.Account;
import com.project.bankmanagement.repository.AccountRepository;

@Component
public class Validator {

	@Autowired
	private AccountRepository accountRepository;

	/*
	 * Validates if account exists
	 */
	public boolean validateAccount(String id) {
		accountRepository.getAllAccountsList();
		Map<String, Account> map = accountRepository.getAllAccount();
		return map.containsKey(id);
	}

	/*
	 * Validates if account has sufficient balance
	 */
	public boolean validatePayment(String id, double amount) {
		return accountRepository.getAllAccount().get(id).getBalance() >= amount;
	}

}
