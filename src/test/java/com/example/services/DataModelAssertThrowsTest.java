package com.example.services;

import com.example.model.Race;
import com.example.model.TolkienCharacter;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataModelAssertThrowsTest {

    @Test
    @DisplayName("Access to the fellowship throws exception if outside the valid range")
    void outOfRangeException() {
        DataService dataService = new DataService();
        assertThrows(IndexOutOfBoundsException.class, () -> dataService.getFellowship().get(20));
    }

    @Test
    @DisplayName("Setting negative age via setter to a TolkienCharacter throws exception")
    public void negativeAgeThrowsExceptionViaSetter() {
        assertThrows(IllegalArgumentException.class, () -> {
            TolkienCharacter frodo = new TolkienCharacter("Frodo", 33, Race.HOBBIT);
            frodo.setAge(-2);
        });
    }

    @Test
    @DisplayName("Setting negative age via constructor to a TolkienCharacter throws exception")
    public void negativeAgeThrowsExceptionViaConstructor() {
        assertThrows(IllegalArgumentException.class,
                () -> new TolkienCharacter("Frodo", -1, Race.HOBBIT));
    }
}