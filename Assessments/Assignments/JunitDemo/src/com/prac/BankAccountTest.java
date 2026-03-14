package com.prac;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
	
public class BankAccountTest {
	
	
	@ParameterizedTest
	@ValueSource(ints={2000,3000,8000,10})
	void testDeposit(int a) {
		BankAccount b = new BankAccount();
		assertTrue(b.depositAmount(a));
		}

 

	@ParameterizedTest
	@ValueSource(ints={-300,-200,-100,0})
	void testDepositException(int a) {
		BankAccount b = new BankAccount();
		assertThrows(InvalidAmountException.class,()->b.depositAmount(a));
		}




	@ParameterizedTest
	@ValueSource(ints={100000,200000,-100,0})
	void testWithdraw(int a) {
		BankAccount b = new BankAccount();
		b.depositAmount(10000);
		assertThrows(InvalidAmountException.class,()->b.withdrwAmount(a));
		}



	@ParameterizedTest
	@ValueSource(ints={1000,200,100,10})
	void testWithdrawException(int a) {
		BankAccount b = new BankAccount();
		b.depositAmount(10000);
		assertTrue(b.withdrwAmount(a));
		}
}




