package com.project.bankmanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.bankmanagement.entity.Account;
import com.project.bankmanagement.entity.Payment;
import com.project.bankmanagement.entity.PaymentRequest;
import com.project.bankmanagement.repository.AccountRepository;
import com.project.bankmanagement.repository.PaymentRepository;
import com.project.bankmanagement.service.BankService;
import com.project.bankmanagement.util.ErrorResponses;

@RestController
public class BankController {

	Logger LOG = LoggerFactory.getLogger(BankController.class);
	
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private BankService bankService;

	@GetMapping("/v1/accounts")
	public ResponseEntity<List<Account>> getAccounts() {
		LOG.info("API call: Get Accounts");
		return new ResponseEntity<List<Account>>(accountRepository.getAllAccountsList(), HttpStatus.OK);
	}

	@PostMapping("v1/payments")
	public ResponseEntity<String> processTransaction(@RequestBody PaymentRequest paymentRequest) {
		LOG.info("API call: Process Payment");
		try {
			if(paymentRequest.getAmount() <= 0 || paymentRequest.getFrom_account().isBlank() || paymentRequest.getTo_account().isBlank()) { //validation of request, blank and null checks
				LOG.info("Error processing Payment: Invalid Request");
				return ErrorResponses.INVALID_REQUEST_ERROR;
			}
		} catch (NullPointerException e) {
			LOG.info("Error processing Payment: Invalid Request Null Pointer");
			return ErrorResponses.INVALID_REQUEST_ERROR;
		}

		return bankService.makePayment(paymentRequest.getFrom_account(), paymentRequest.getTo_account(), paymentRequest.getAmount());
	}

	@GetMapping("/v1/payments")
	public ResponseEntity<List<Payment>> getPayments() {
		LOG.info("API call: Get Payments");
		return new ResponseEntity<List<Payment>>(paymentRepository.getAllPayments(), HttpStatus.OK);
	}

}
