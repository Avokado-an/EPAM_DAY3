package com.anton.day3.service;

import com.anton.day3.entity.Ball;
import com.anton.day3.entity.BallColor;
import com.anton.day3.entity.Basket;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class BasketServiceTest {
    public static BasketService service;

    @BeforeClass
    public static void setup() {
        service = new BasketService();
    }

    @Test
    public void addBallValidTest() {
        Basket basket = new Basket(1, 10);
        Ball ball = new Ball(4, BallColor.YELLOW);
        boolean flag = service.addBall(basket, ball);
        assertTrue(flag);
    }

    @DataProvider(name = "invalidBasketAndBall")
    public static Object[][] createInvalidBasketAndBall() {
        return new Object[][]{
                {new Basket(1, 10), new Ball(4, BallColor.YELLOW)},
                {new Basket(2, 10), new Ball(6, BallColor.YELLOW)},
                {new Basket(), null}, {null, new Ball(2, BallColor.GREEN)}, {null, null}
        };
    }

    @Test(dataProvider = "invalidBasketAndBall")
    public void addBallInvalidTest(Basket basket, Ball ball) {
        service.addBall(basket, ball);
        boolean flag = service.addBall(basket, ball);
        assertFalse(flag);
    }

    @DataProvider(name = "BasketAndBalls")
    public static Object[][] createBasketAndBall() {
        return new Object[][]{
                {new Basket(Arrays.asList(
                        new Ball(4, BallColor.YELLOW), new Ball(10, BallColor.BLUE),
                        new Ball(15, BallColor.BLUE), new Ball(7, BallColor.GREEN), null))
                }
        };
    }

    @Test(dataProvider = "BasketAndBalls")
    public void calculateTotalWeightValidTest(Basket basket) {
        int expectedWeight = service.calculateTotalWeight(basket);
        int actualWeight = 36;
        assertEquals(expectedWeight, actualWeight);
    }

    @Test(dataProvider = "BasketAndBalls")
    public void calculateTotalWeightInvalidTest(Basket basket) {
        int expectedWeight = service.calculateTotalWeight(basket);
        int actualWeight = 20;
        assertNotEquals(expectedWeight, actualWeight);
    }

    @Test(dataProvider = "BasketAndBalls")
    public void countColoredBallsColorValidTest(Basket basket) {
        BallColor ballColor = BallColor.BLUE;
        int expectedAmount = service.countColoredBalls(basket, ballColor);
        int actualAmount = 2;
        assertEquals(expectedAmount, actualAmount);
    }

    @Test(dataProvider = "BasketAndBalls")
    public void countColoredBallsColorInvalidTest(Basket basket) {
        BallColor ballColor = BallColor.GREEN;
        int expectedAmount = service.countColoredBalls(basket, ballColor);
        int actualAmount = 3;
        assertNotEquals(expectedAmount, actualAmount);
    }

    @Test(dataProvider = "BasketAndBalls")
    public void countColoredBallsStringValidTest(Basket basket) {
        String color = "BlUe";
        int expectedAmount = service.countColoredBalls(basket, color);
        int actualAmount = 2;
        assertEquals(expectedAmount, actualAmount);
    }

    @Test(dataProvider = "BasketAndBalls")
    public void countColoredBallsStringInvalidTest(Basket basket) {
        String color = "gReeN";
        int expectedAmount = service.countColoredBalls(basket, color);
        int actualAmount = 3;
        assertNotEquals(expectedAmount, actualAmount);
    }
}