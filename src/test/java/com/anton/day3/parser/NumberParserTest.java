package com.anton.day3.parser;

import com.anton.day3.validator.parser.NumberParser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class NumberParserTest {
    public static NumberParser parser;

    @BeforeClass
    public static void setup() {
        parser = new NumberParser();
    }

    @Test
    public void isValidIntValidTest() {
        boolean isValid = parser.isValidInt("13");
        assertTrue(isValid);
    }

    @DataProvider(name = "invalidInt")
    public Object[][] createInvalidInt() {
        return new Object[][] {
                {"qwer"}, {null}, {"133g"}, {"13.3"}
        };
    }

    @Test(dataProvider = "invalidInt")
    public void isValidIntInvalidTest(String number) {
        boolean isValid = parser.isValidInt(number);
        assertFalse(isValid);
    }

    @Test
    public void isValidDoubleValidTest() {
        boolean isValid = parser.isValidDouble("13.");
        assertTrue(isValid);
    }

    @DataProvider(name = "invalidDouble")
    public Object[][] createInvalidDouble() {
        return new Object[][] {
                {"qwer"}, {null}, {"13.3g"}
        };
    }

    @Test(dataProvider = "invalidDouble")
    public void isValidDoubleInvalidTest(String number) {
        boolean isValid = parser.isValidDouble(number);
        assertFalse(isValid);
    }
}
