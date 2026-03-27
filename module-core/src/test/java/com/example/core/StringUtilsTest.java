package com.example.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void reverseNullReturnsNull() {
        assertNull(StringUtils.reverse(null));
    }

    @Test
    void reverseEmptyStringReturnsEmpty() {
        assertEquals("", StringUtils.reverse(""));
    }

    @Test
    void reverseRegularString() {
        assertEquals("olleh", StringUtils.reverse("hello"));
    }

    @Test
    void isPalindromeWithPalindrome() {
        assertTrue(StringUtils.isPalindrome("racecar"));
        assertTrue(StringUtils.isPalindrome("A man a plan a canal Panama"));
    }

    @Test
    void isPalindromeWithNonPalindrome() {
        assertFalse(StringUtils.isPalindrome("hello"));
    }

    @Test
    void isPalindromeNullReturnsFalse() {
        assertFalse(StringUtils.isPalindrome(null));
    }

    @Test
    void capitalizeString() {
        assertEquals("Hello", StringUtils.capitalize("hello"));
        assertEquals("Hello", StringUtils.capitalize("HELLO"));
    }

    @Test
    void capitalizeNullReturnsNull() {
        assertNull(StringUtils.capitalize(null));
    }

    @Test
    void capitalizeEmptyReturnsEmpty() {
        assertEquals("", StringUtils.capitalize(""));
    }
}
