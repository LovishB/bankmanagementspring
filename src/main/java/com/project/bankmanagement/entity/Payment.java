package com.project.bankmanagement.entity;

import com.project.bankmanagement.util.BankEnums.PaymentType;

public abstract class Payment {

	PaymentType direction;

	public abstract void setDirection(PaymentType direction);

	public abstract PaymentType getDirection();

}
