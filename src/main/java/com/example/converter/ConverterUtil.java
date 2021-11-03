package com.example.converter;

public class ConverterUtil {

    public static float convertFahrenheitToCelsius(float fahrenheit) {
        return ((fahrenheit - 32) * 5 / 9);
    }

    public static float convertCelsiusToFahreheit(float celsius) {
        return ((celsius * 9) / 5) + 32;
    }
}
