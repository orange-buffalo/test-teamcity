package com.example.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    @Test
    void addTwoNumbers() {
        assertEquals(5, MathUtils.add(2, 3));
    }

    @Test
    void addNegativeNumbers() {
        assertEquals(-1, MathUtils.add(-3, 2));
    }

    @Test
    void subtractNumbers() {
        assertEquals(1, MathUtils.subtract(3, 2));
    }

    @Test
    void multiplyNumbers() {
        assertEquals(6, MathUtils.multiply(2, 3));
    }

    @Test
    void divideNumbers() {
        assertEquals(2.0, MathUtils.divide(6, 3));
    }

    @Test
    void divideByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> MathUtils.divide(5, 0));
    }

    @Test
    void isEvenWithEvenNumber() {
        assertTrue(MathUtils.isEven(4));
    }

    @Test
    void isEvenWithOddNumber() {
        assertFalse(MathUtils.isEven(3));
    }
}
