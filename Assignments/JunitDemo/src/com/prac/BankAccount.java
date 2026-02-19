package com.prac;

public class BankAccount {
	double amount;
	double totalBalance=0;
	
	boolean depositAmount(double amount) {
		if(amount<=0) {
			throw new InvalidAmountException("Amount cannot be negative or 0");
		}
		totalBalance+=amount;
		return true;
	}
	
	boolean withdrwAmount(double amount) {
		
		if(amount<=0) {
			throw new InvalidAmountException("Invalid amount entered");
		}
		if(totalBalance<=0) {
			throw new InvalidAmountException("Balancw low cannot withdraw money");
		}
		
		if(amount>totalBalance) {
			throw new InvalidAmountException("Cannot withdraw amount to high");
		}
		totalBalance-=amount;
		return true;
	}
}


class InvalidAmountException extends RuntimeException{
	public InvalidAmountException(String msg) {
		super(msg);
	}
}


