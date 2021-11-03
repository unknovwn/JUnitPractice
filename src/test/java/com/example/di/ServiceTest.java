package com.example.di;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {

    @Test
    @DisplayName("Service has only one constructor annotated with @Inject")
    void JSR330Constructor() {
        int count = 0;
        Constructor<?>[] constructors = Service.class.getConstructors();
        for (Constructor<?> constructor : constructors) {
            if (constructor.isAnnotationPresent(Inject.class)) {
                count++;
            }
        }
        assertEquals(1, count);
    }
}