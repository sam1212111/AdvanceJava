package com.demo.palindrome;

public class Palindrome {
	
	public boolean isPalindrome(int num) {
		String s= num+"";
		return s.equals(new StringBuilder(s).reverse().toString());
		
	}

}
