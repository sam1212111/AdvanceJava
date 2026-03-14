package com.exception;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ValidationTest {

	
	@Test
	void AgeValidationTest() {
		Validation v = new Validation();
		assertThrows(IllegalArgumentException.class,()->v.validateAge(-1));
	}
}
