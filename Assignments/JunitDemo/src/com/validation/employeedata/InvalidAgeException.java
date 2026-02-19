package com.validation.employeedata;

public class InvalidAgeException extends RuntimeException {
	public InvalidAgeException(String msg) {
		super(msg);
	}
}
