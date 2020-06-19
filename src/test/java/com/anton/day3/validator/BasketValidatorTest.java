package com.anton.day3.validator;

import com.anton.day3.exception.BasketValidatorException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class BasketValidatorTest {
    public static BasketValidator validator;

    @BeforeClass
    public static void setup() {
        validator = new BasketValidator();
    }

    @Test
    public void validateWeightValidTest() {
        try {
            double expectedWeight = validator.validateWeight("100");
            int actualWeight = 100;
            assertEquals(expectedWeight, actualWeight);
        } catch (BasketValidatorException ex) {
            fail();
        }
    }

    @DataProvider(name = "invalidWeight")
    public static Object[][] createInvalidWeight() {
        return new Object[][]{
                {"1050"}, {"-1"}, {"qwerwq"}, {null}
        };
    }

    @Test(expectedExceptions = BasketValidatorException.class, dataProvider = "invalidWeight")
    public void validateWeightExceptionTest(String expectedWeight) throws BasketValidatorException {
        validator.validateWeight(expectedWeight);
    }

    @Test
    public void validateCapacityValidTest() {
        try {
            int expectedColor = validator.validateCapacity("15");
            int actualCapacity = 15;
            assertEquals(expectedColor, actualCapacity);
        } catch (BasketValidatorException ex) {
            fail();
        }
    }

    @DataProvider(name = "invalidCapacity")
    public static Object[][] createInvalidCapacity() {
        return new Object[][]{
                {"100"}, {"-1"}, {"qwerwq"}, {null}
        };
    }

    @Test(expectedExceptions = BasketValidatorException.class, dataProvider = "invalidCapacity")
    public void validateCapacityExceptionTest(String capacity) throws BasketValidatorException {
        validator.validateCapacity(capacity);
    }
}
