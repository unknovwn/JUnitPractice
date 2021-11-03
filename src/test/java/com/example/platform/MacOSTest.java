package com.example.platform;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MacOSTest {

    // Run only on MacOS
    @Test
    void testName() throws Exception {
        Assumptions.assumeTrue(System.getProperty("os.name").contains("Mac"));
        assertTrue(true);
    }
}
