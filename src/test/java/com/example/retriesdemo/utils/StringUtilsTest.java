package com.example.retriesdemo.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringUtilsTest {

    @Test
    public void testReverseString_GivenNullString_ReturnsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () ->
                StringUtils.reverse(null)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "parametersToTest")
    public void testReverseString_GivenNotNullString_ReturnsReversed(
            String testString,
            String expectedResult
    ) {
        final String actual = StringUtils.reverse(testString);

        assertEquals(expectedResult, actual);
    }

    private static Object[] parametersToTest() {
        return new Object[] {
                new Object[] {"Some string", "gnirts emoS"},
                new Object[] {"Hello", "olleH"},
                new Object[] {"abc", "cba"},
        };
    }


}