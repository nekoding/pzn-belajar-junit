package com.nekoding.belajar.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.util.Properties;

public class CalculatorTest {

    @BeforeEach
    public void setUp() {
        System.out.println("Run before each unit test");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Run after each unit test");
    }

    private Calculator calculator = new Calculator();

    @Test
    public void testAddSuccess() {
        var result = calculator.add(10, 10);
        assertEquals(20, result);
    }

    @Test
    public void testDivideFailed() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0));
    }

    @Test
    @Disabled
    public void testDisableTest() {}

    @Test
    @DisabledOnOs({OS.LINUX})
    public void testDisableOnLinux() {}

    @Test
    @EnabledOnOs({OS.LINUX})
    public void testRunOnlyOnLinux() {}

    @Test
    @DisabledOnJre({JRE.JAVA_21})
    public void testDisableOnJre21() {}

    @Test
    @EnabledOnJre({JRE.JAVA_21})
    public void testRunOnlyOnJre21() {}

    @Test
    public void testGetSystemProperties() {
        Properties properties = System.getProperties();
        properties.forEach((key, value) -> System.out.println(key + " : " + value));
    }

    @Test
    @DisabledIfSystemProperties({
            @DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle")
    })
    public void disableOnJavaOracle() {}

    @Test
    @EnabledIfSystemProperties({
            @EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle")
    })
    public void enableOnJavaOracle() {}
}
