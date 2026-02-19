package com.exception;

public class Validation {

	Boolean validateAge(int age) {
		if(age<0) {
		throw new IllegalArgumentException("Age cannot be 0");
		}
		if(age>=18&& age<=60) {
			return true;
		}
		return false;
	}
}
