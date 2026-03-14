package com.validation.employeedata;

public class InvalidNameException extends RuntimeException {
	public InvalidNameException(String msg) {
		super(msg);
	}
}
