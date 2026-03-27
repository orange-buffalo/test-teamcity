package com.example.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorApiTest {

    private CalculatorApi calculator;

    @BeforeEach
    void setUp() {
        calculator = new CalculatorApi();
    }

    @Test
    void addReturnsSum() {
        assertEquals(7, calculator.add(3, 4));
    }

    @Test
    void subtractReturnsDifference() {
        assertEquals(1, calculator.subtract(4, 3));
    }

    @Test
    void multiplyReturnsProduct() {
        assertEquals(12, calculator.multiply(3, 4));
    }

    @Test
    void divideReturnsQuotient() {
        assertEquals(2.5, calculator.divide(5, 2));
    }

    @Test
    void divideByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
    }

    @Test
    void describeEvenNumber() {
        assertEquals("4 is even", calculator.describeNumber(4));
    }

    @Test
    void describeOddNumber() {
        assertEquals("3 is odd", calculator.describeNumber(3));
    }
}
