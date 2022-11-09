package com.project.bankmanagement.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.bankmanagement.entity.PaymentCredit;
import com.project.bankmanagement.entity.PaymentDebit;
import com.project.bankmanagement.repository.AccountRepository;
import com.project.bankmanagement.repository.PaymentRepository;
import com.project.bankmanagement.util.BankEnums.PaymentType;
import com.project.bankmanagement.util.ErrorResponses;
import com.project.bankmanagement.validator.Validator;

@Service
public class BankService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private Validator validator;

	public ResponseEntity<String> makePayment(String fromAccountId, String toAccountId, double amount) {

		Logger LOG = LoggerFactory.getLogger(BankService.class);

		if(!validator.validateAccount(fromAccountId)) {
			LOG.info("Error processing Payment: Account [" + fromAccountId + "] Not Found");
			return ErrorResponses.FROM_ACCOUNT_ERROR;
		}

		if(!validator.validateAccount(toAccountId)) {
			LOG.info("Error processing Payment: Account [" + toAccountId + "] Not Found");
			return ErrorResponses.TO_ACCOUNT_ERROR;
		}

		if(!validator.validatePayment(fromAccountId, amount)) {
			LOG.info("Error processing Payment: Low Balance in Account [" + fromAccountId + "]");
			return ErrorResponses.LOW_BALANCE_ERROR;
		}

		//Updating account balances(processing transaction)
		double fromAccountBalance = accountRepository.getAccountBalance(fromAccountId);
		double toAccountBalance = accountRepository.getAccountBalance(toAccountId);
		accountRepository.updateAccountBalance(fromAccountId, fromAccountBalance - amount);
		accountRepository.updateAccountBalance(toAccountId, toAccountBalance + amount);
		paymentRepository.addPayment(new PaymentDebit(fromAccountId, toAccountId, PaymentType.outgoing, amount));
		paymentRepository.addPayment(new PaymentCredit(toAccountId, fromAccountId, PaymentType.incoming, amount));

		LOG.info("Payment Successful");
		return new ResponseEntity<String>("Payment Successful", HttpStatus.OK);
	}
}
