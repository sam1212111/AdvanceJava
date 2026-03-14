package com.validator;

public class AgeValidator {
	private Database db1;
	
	//Constructor injection
	public AgeValidator(Database db) {
		this.db1=db;
	}
	void validateAge(int age) throws IllegalArgumentException {
		if(age<0) {
			throw new IllegalArgumentException("Age can't be negative");
		}
			

		//save age only if valid
		db1.saveAge(age);
	}
	
}
