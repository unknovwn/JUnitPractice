package com.example;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
       calculator = new Calculator();
    }

    @Test
    @DisplayName("Simple multiplication")
    void testMultiplication() {
        assertEquals(20, calculator.multiply(4, 5),
                "Multiply 4 by 5");
        assertEquals(20, calculator.multiply(5, 4),
                "Multiply 5 by 4");
        assertEquals(36, calculator.multiply(6, 6),
                "Multiply 6 by 6");
        assertEquals(1024, calculator.multiply(512, 2),
                "Multiply 512 by 2");
    }

    @RepeatedTest(5)
    @DisplayName("Multiplication with zero")
    void testMultiplicationWithZero() {
        Assumptions.assumeFalse(System.getProperty("os.name").contains("Linux"));
        assertEquals(0, calculator.multiply(4, 0),
                "Multiply 4 by 0");
        assertEquals(0, calculator.multiply(0, 4),
                "Multiply 0 by 4");
        assertEquals(0, calculator.multiply(0, -4),
                "Multiply 0 by -4");
        assertEquals(0, calculator.multiply(0, 0),
                "Multiply 0 by 0");
    }

    @Test
    @DisplayName("Multiplication of negative numbers")
    void testMultiplicationNegative() {
        assertEquals(-12, calculator.multiply(4, -3),
                "Multiply 4 by -3");
        assertEquals(12, calculator.multiply(-4, -3),
                "Multiply -4 by -3");
    }

    @Test
    @DisplayName("Multiplication timeout test")
    void testMultiplicationTimeout() {
        assertTimeout(Duration.ofSeconds(1), () -> calculator.multiply(4000, 5000));
    }
}