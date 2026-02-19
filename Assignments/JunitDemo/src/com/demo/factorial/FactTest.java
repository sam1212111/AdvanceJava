package com.demo.factorial;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FactTest {
	
	@Test
	public void testFactorial() {
		Fact fact = new Fact();
		int result = fact.factorial(5);
		assertEquals(120, result);
	}

}
