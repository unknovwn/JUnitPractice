package com.example.nested;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class UsingNestedTests {

    List<String> list;

    @BeforeEach
    void setUp() {
        list = List.of("JUnit 5", "Mockito");
    }

    @Test
    void listTests() {
        assertEquals(2, list.size());
    }

    @Nested
    @DisplayName("Grouping tests for checking members")
    class CheckMembers {

        @Test
        void checkFirstElement() {
            assertEquals("JUnit 5", list.get(0));
        }

        @Test
        void checkSecondElement() {
            assertEquals("Mockito", list.get(1));
        }
    }
}
