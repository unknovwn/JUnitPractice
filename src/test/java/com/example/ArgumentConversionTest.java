package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ArgumentConversionTest {

    Logger log = LoggerFactory.getLogger(ArgumentConversionTest.class);

    @ParameterizedTest
    @ValueSource(ints = {1, 12, 42})
    @DisplayName("Explicit argument conversion")
    void testWithExplicitArgumentConversion(@ConvertWith(ToOctalStringConverter.class) String argument) {
        log.debug("Converted argument: {}", argument);
        assertNotNull(argument);
    }

    static class ToOctalStringConverter extends SimpleArgumentConverter {

        @Override
        protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
            assertEquals(source.getClass(), Integer.class, "Can only convert from Integers");
            assertEquals(targetType, String.class, "Can only convert to String");
            return Integer.toOctalString((Integer) source);
        }
    }
}
