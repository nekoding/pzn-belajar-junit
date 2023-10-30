package com.nekoding.belajar.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedTest {

    private Calculator calculator = new Calculator();

    @DisplayName("Test calculator")
    @org.junit.jupiter.params.ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    public void testCase1(Integer num) {
        var expected = num + num;
        var result = calculator.add(num, num);

        Assertions.assertEquals(expected, result);
    }
}
