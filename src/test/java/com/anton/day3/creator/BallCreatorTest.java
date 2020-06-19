package com.anton.day3.creator;

import com.anton.day3.entity.Ball;
import com.anton.day3.entity.BallColor;
import com.anton.day3.exception.BallValidatorException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class BallCreatorTest {
    private BallCreator creator;

    @BeforeClass
    public void setup() {
        creator = new BallCreator();
    }

    @Test
    public void validateBallValidTest() {
        try {
            Ball expectedBall = creator.createBall("15", "yellow");
            Ball actualBall = new Ball(15, BallColor.YELLOW);
            assertEquals(expectedBall, actualBall);
        } catch (BallValidatorException ex) {
            fail();
        }
    }

    @DataProvider(name = "invalidBall")
    public static Object[][] createInvalidBall() {
        return new Object[][]{
                {"55", "yellow"}, {"-1", "yellow"},
                {"qwerwq", "yellow"}, {"15", "wert"},
                {null, "yellow"}, {"15", null}, {null, null}
        };
    }

    @Test(expectedExceptions = BallValidatorException.class, dataProvider = "invalidBall")
    public void validateBallExceptionTest(String weight, String color) throws BallValidatorException {
        creator.createBall(weight, color);
    }
}
