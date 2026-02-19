package com.demo.calculator;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {
	
	
//	@ValueSource(ints={1,2,3,4})
	
//here ints is a array of int means prural form of int and it is same for other datatype like floats,doubles,booleans,strings,chars
	
	@ParameterizedTest
	@CsvSource({"2,2,4","5,5,10","3,5,8"})
	void testAddition(int a,int b,int expected) {
		Calculator calculator = new Calculator();
		assertEquals(expected, calculator.add(a, b));
	}
	
	@ParameterizedTest
	@CsvSource({"2,2,0","5,5,0","3,5,-2"})
	void testSubtraction(int a,int b,int expected) {
		Calculator calculator = new Calculator();
		assertEquals(expected, calculator.sub(a, b));
	}
	
	
	@ParameterizedTest
	@CsvSource({"2,2,1","5,5,1","3,5,9"})
	void testDivision(int a,int b,int expected) {
		Calculator calculator = new Calculator();
		assertEquals(expected, calculator.div(a, b));
	}
	
	
	@ParameterizedTest
	@CsvSource({"2,2,4","5,5,25","3,5,15"})
	void testMultiplication(int a,int b,int expected) {
		Calculator calculator = new Calculator();
		assertEquals(expected, calculator.multiply(a, b));
	}
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "./Resources1/Testdata.csv",numLinesToSkip = 0)
	void testAdditionWithCsvFile(int a,int b,int expected) {
		Calculator calculator = new Calculator();
		assertEquals(expected, calculator.add(a, b));
	}
	
	@Test
	public void testAdd() {
		Calculator calculator = new Calculator();
		int result = calculator.add(2, 3);
		assertEquals(5, result);
	}
	
	@Test
	public void test1Sub() {
		Calculator calculator = new Calculator();
		int result = calculator.sub(2, 3);
		assertEquals(5, result);
	}
	
	@Test
	public void test2Multiply() {
		Calculator calculator = new Calculator();
		int result = calculator.multiply(2, 3);
		assertEquals(5, result);
	}
	
	@Test
	public void test3Div() {
		Calculator calculator = new Calculator();
		double result = calculator.div(2, 3);
		assertEquals(5, result);
	}
	
	
	@Test
	public void test4DivByZero() {
		Calculator calculator = new Calculator();
		assertThrows(IllegalArgumentException.class, () -> {
			calculator.div(2, 0);
		});
	}
}
