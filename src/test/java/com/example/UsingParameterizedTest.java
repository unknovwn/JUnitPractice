package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class UsingParameterizedTest {

    static int[][] data() {
        return new int[][] {
                {1, 2, 2},
                {5, 3, 15},
                {121, 4, 484}
        };
    }

    @ParameterizedTest(name = "{index} called with: {0}")
    @MethodSource(value = "data")
    @DisplayName("Simple multiplication")
    void testWithStringParameter(int[] data) {
        Calculator calculator = new Calculator();
        int m1 = data[0];
        int m2 = data[1];
        int expected = data[2];
        assertEquals(expected, calculator.multiply(m1, m2));
    }

    @ParameterizedTest(name = "{0} contains \"window\"")
    @ValueSource(strings = { "WINDOW", "Microsoft Windows [Version 10.?]" })
    @DisplayName("String contains \"window\"")
    void stringContainsWindow(String name) {
        assertTrue(name.toLowerCase(Locale.ROOT).contains("window"));
    }

    @ParameterizedTest(name = "For example, year {0} is not supported")
    @ValueSource(ints = { -1, -4 })
    @DisplayName("A negative value for year is not supported by the leap year computation.")
    void yearIsNotNegative(int year) {
        assertTrue(year < 0);
    }

    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({ "0, 1, 0", "1, 2, 2", "49, 50, 2450", "1, 100, 100" })
    @DisplayName("Multiplication")
    void add(int first, int second, int expectedResult) {
        Calculator calculator = new Calculator();
        assertEquals(expectedResult, calculator.multiply(first, second),
                () -> first + " * " + second + " = " + expectedResult);
    }
}
