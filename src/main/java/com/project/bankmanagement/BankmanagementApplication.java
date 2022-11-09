package com.project.bankmanagement;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.bankmanagement.entity.Account;
import com.project.bankmanagement.repository.AccountRepository;
import com.project.bankmanagement.util.BankEnums.Currency;

@SpringBootApplication
public class BankmanagementApplication implements CommandLineRunner {
	
	Logger LOG = LoggerFactory.getLogger(BankmanagementApplication.class);

	@Autowired
	AccountRepository accountRepository;

	public static void main(String[] args) {
		SpringApplication.run(BankmanagementApplication.class, args);
	}

	/*
	 * Using command Line runner to initialize accounts
	 */
	@Override
	public void run(String... args) throws Exception {
		Map<String, Account> allAccounts = new HashMap<>();	//Account Map<account no, account details>
		allAccounts.put("bob123", new Account("bob123", "bob", 100, Currency.INR));
		allAccounts.put("alice456", new Account("alice456", "alice", 100, Currency.INR));
		LOG.info("Creating Accounts in Bank");
		accountRepository.setAllAccounts(allAccounts);	
	}

}
