package com.example.email;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {

    @Test
    @DisplayName("EmailValidator returns true for valid email")
    void returnsTrueForValidEmail() {
        assertTrue(EmailValidator.isValidEmail("lars.vogel@gmail.com"));
    }

    @Test
    @DisplayName("Usage of subdomain is still valid")
    void correctEmailSubdomainReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("example@test.example.com"));
        assertTrue(EmailValidator.isValidEmail("example@test.test2.example.com"));
    }

    @Test
    @DisplayName("Missing top level domain returns false")
    void invalidEmailNoTldReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("example@test"));
    }

    @Test
    @DisplayName("Double dot returns false")
    void invalidEmailDoubleDotReturnsFalse() {
        assertTrue(EmailValidator.isValidEmail("lars..vogel@test.com"));
        assertFalse(EmailValidator.isValidEmail("example@test..com"));
    }

    @Test
    @DisplayName("Missing username returns false")
    void invalidEmailNoUsernameReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("@test.com"));
    }

    @Test
    @DisplayName("Empty string returns false")
    void emptyStringReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(""));
    }

    @Test
    @DisplayName("Null email returns false")
    void nullReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(null));
    }
}