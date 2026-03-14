package com.validation.employeedata;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class EmployeeMain {
	@Test
	public void validateNameValidTest1() {
		Validator v = new Validator();
		assertTrue(v.validateName("Sam Johns"));
	}
	
	@Test
	public void validateNameInValidTest1() {
		Validator v = new Validator();
		assertFalse(v.validateName("Jonathan"));
	}
	
	@Test
	public void validateAgeValidTest1() {
		Validator v = new Validator();
		assertTrue(v.validateAge(18));
	}
	
	@Test
	public void validateAgeInValidTest1() {
		Validator v = new Validator();
		assertFalse(v.validateAge(17));
	}
	
	@Test
	public void validateInvalidNameTest() {
		Employee e = new Employee("Maria",2000 , 25);
		Validator v = new Validator();
		assertThrows(InvalidNameException.class,()->v.validate(e));
	}
	
	@Test
	public void validateInvalidAgeTest() {
		Employee e = new Employee("Maria Francis",2000 , 17);
		Validator v = new Validator();
		assertThrows(InvalidAgeException.class,()->v.validate(e));
	}
	
	@Test
	public void calculateAnnualSalaryValidTest1() {
		Employee e = new Employee("Maria Francis",2000 ,18);
		assertEquals(38400.0, e.calculateAnnualSalary());
	}
	
	
	
	
	
	

	public static void main(String[] args) {
		Employee e = new Employee("Sam Johns",2000,20);
		Validator v = new Validator();
		
		try {
		v.validate(e);
		System.out.println(e.calculateAnnualSalary());
		}catch(InvalidAgeException i) {
			System.out.println(i.getMessage());
		}catch(InvalidNameException n) {
			System.out.println(n.getMessage());
		}
		
		
	}
	
	

}
