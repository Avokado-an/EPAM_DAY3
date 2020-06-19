package com.anton.day3.creator;

import com.anton.day3.entity.Basket;
import com.anton.day3.exception.BasketValidatorException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class BasketCreatorTest {
    BasketCreator creator;

    @BeforeClass
    public void setup() {
        creator = new BasketCreator();
    }

    @Test
    public void validateBasketValidTest() {
        try {
            Basket expectedBasket = creator.createBasket("15", "100");
            Basket actualBasket = new Basket(15, 100);
            assertEquals(expectedBasket, actualBasket);
        } catch (BasketValidatorException ex) {
            fail();
        }
    }

    @DataProvider(name = "invalidBasket")
    public static Object[][] createInvalidBasket() {
        return new Object[][]{
                {"55", "1050"}, {"-1", "1050"},
                {"-1", "-1"}, {"55", "-1"},
                {"55", "100"}, {"-1", "100"},
                {"15", "1050"}, {"15", "-1"},
                {"qwerwq", "50"}, {"15", "qwer"},
                {"qwer", "dsfgsd"}, {"sdfg", "cxbv"},
                {null, "100"}, {"15", null}, {null, null}
        };
    }

    @Test(expectedExceptions = BasketValidatorException.class, dataProvider = "invalidBasket")
    public void validateBallExceptionTest(String weight, String capacity) throws BasketValidatorException {
        creator.createBasket(weight, capacity);
    }
}
