package com.demo.palindrome;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PalindromeTest {

    Palindrome p;

    @BeforeEach
    void init() {
        p = new Palindrome();
    }
    
//    @ParameterizedTest
//    @ValueSource(strings={"saaas","mom"})
//    void testIsPalindrome(int a) {
//    	assertTrue(p.isPalindrome(a));
//    }

    @Test
    void testIsPalindrome() {
        assertTrue(p.isPalindrome(121));
    }
}
