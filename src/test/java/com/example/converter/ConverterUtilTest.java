package com.example.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ConverterUtilTest {

    int[][] celsiusFahrenheitMapping = new int[][] {
            {10, 50},
            {40, 104},
            {0, 32}
    };

    @TestFactory
    @DisplayName("Celsius converts to Fahrenheit correctly")
    Stream<DynamicTest> celsiusToFahrenheit() {
        return Arrays.stream(celsiusFahrenheitMapping).map((entry) -> {
            int celsius = entry[0];
            int fahrenheit = entry[1];
            return DynamicTest.dynamicTest(celsius + "ºC = " + fahrenheit + "ºF", () -> {
                assertEquals(fahrenheit, ConverterUtil.convertCelsiusToFahreheit(celsius));
            });
        });
    }

    @TestFactory
    @DisplayName("Fahrenheit converts to Celsius correctly")
    Stream<DynamicTest> fahrenheitToCelsius() {
        return Arrays.stream(celsiusFahrenheitMapping).map((entry) -> {
            int celsius = entry[0];
            int fahrenheit = entry[1];
            return DynamicTest.dynamicTest(fahrenheit + "ºF = " + celsius + "ºC", () -> {
                assertEquals(celsius, ConverterUtil.convertFahrenheitToCelsius(fahrenheit));
            });
        });
    }
}