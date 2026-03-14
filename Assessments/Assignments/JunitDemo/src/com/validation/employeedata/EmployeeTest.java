package com.validation.employeedata;



import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class EmployeeTest {

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
		assertThrows(InvalidNameException.class,()->v.validate(e));
	}
}
