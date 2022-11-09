package com.project.bankmanagement.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrorResponses {

	public static final ResponseEntity<String> FROM_ACCOUNT_ERROR =  new ResponseEntity<String>("From Account Not Found", HttpStatus.BAD_REQUEST);
	
	public static final ResponseEntity<String> TO_ACCOUNT_ERROR =  new ResponseEntity<String>("To Account Not Found", HttpStatus.BAD_REQUEST);
	
	public static final ResponseEntity<String> LOW_BALANCE_ERROR =  new ResponseEntity<String>("Low Balnce In your Back Account", HttpStatus.BAD_REQUEST);
	
	public static final ResponseEntity<String> INVALID_REQUEST_ERROR =  new ResponseEntity<String>("Invalid Request Made", HttpStatus.BAD_REQUEST);
	
}
