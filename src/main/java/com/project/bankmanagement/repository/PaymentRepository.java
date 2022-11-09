package com.project.bankmanagement.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.bankmanagement.entity.Payment;

@Repository
public class PaymentRepository {
	
	private List<Payment> payments;
	
	public PaymentRepository() {
		payments = new ArrayList<>();
	}
	
	public List<Payment> getAllPayments() {
		return payments;
	}
	
	public void addPayment(Payment payment) {
		payments.add(payment);
	}

}
