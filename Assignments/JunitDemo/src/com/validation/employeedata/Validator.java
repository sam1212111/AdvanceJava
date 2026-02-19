package com.validation.employeedata;


public class Validator{
	
	boolean validateName(String name) {
		if(name.length()>8) {
			return true;
		}
		return false;
	}
	
	Boolean validateAge(int age) {
		if(age>=18&& age<=60) {
			return true;
		}
		return false;
	}
	
	public void validate(Employee employee) {
		if(!validateName(employee.getName())) {
			throw new InvalidNameException("Name is Invalid!!");
		}
		if(!validateAge(employee.getAge())) {
			throw new InvalidAgeException("Age is Invalid!!");
		}
		System.out.println("Name and Age is Valid");	
	

	}
}
