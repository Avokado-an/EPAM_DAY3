package com.anton.day3.validator;

import com.anton.day3.entity.BallColor;
import com.anton.day3.exception.BallValidatorException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class BallValidatorTest {
    public static BallValidator validator;

    @BeforeClass
    public static void setup() {
        validator = new BallValidator();
    }

    @Test
    public void validateWeightValidTest() {
        try {
            double expectedWeight = validator.validateWeight("15");
            int actualWeight = 15;
            assertEquals(expectedWeight, actualWeight);
        } catch (BallValidatorException ex) {
            fail();
        }
    }

    @DataProvider(name = "invalidWeight")
    public static Object[][] createInvalidWeight() {
        return new Object[][]{
                {"55"}, {"-1"}, {"qwerwq"}, {null}
        };
    }

    @Test(expectedExceptions = BallValidatorException.class, dataProvider = "invalidWeight")
    public void validateWeightExceptionTest(String expectedWeight) throws BallValidatorException {
        validator.validateWeight(expectedWeight);
    }

    @Test
    public void validateColorValidTest() {
        try {
            BallColor expectedBallColor = validator.validateColor("yellow");
            BallColor actualBallColor = BallColor.YELLOW;
            assertEquals(expectedBallColor, actualBallColor);
        } catch (BallValidatorException ex) {
            fail();
        }
    }

    @DataProvider(name = "invalidColor")
    public static Object[][] createInvalidColor() {
        return new Object[][]{
                {"yelllllllloooooowwww"}, {null}
        };
    }

    @Test(expectedExceptions = BallValidatorException.class, dataProvider = "invalidColor")
    public void validateColorExceptionTest(String color) throws BallValidatorException {
        validator.validateColor(color);
    }
}
