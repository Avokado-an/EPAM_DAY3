package com.anton.day3.service;

import com.anton.day3.entity.Ball;
import com.anton.day3.entity.BallColor;
import com.anton.day3.entity.Basket;

public class BasketService {
    public boolean addBall(Basket basket, Ball ball) {
        boolean flag = false;
        if ((basket != null && ball != null) && (!isFull(basket) && !isTooHeavy(basket, ball))) {
            flag = true;
            basket.addBall(ball);
        }
        return flag;
    }

    public boolean removeBall(Basket basket, int id) {
        boolean flag = false;
        int minPositive = 0;
        if (basket != null && (id >= minPositive && id < basket.getCurrentSize())) {
            flag = true;
            basket.removeBall(id);
        }
        return flag;
    }

    public int calculateTotalWeight(Basket basket) {
        int totalWeight = 0;
        if (basket != null) {
            for (Ball ball : basket.getBalls()) {
                if (ball == null) {
                    continue;
                }
                totalWeight += ball.getWeight();
            }
        }
        return totalWeight;
    }

    public int countColoredBalls(Basket basket, BallColor color) {
        int coloredBalls = 0;
        if (basket != null && color != null) {
            for (Ball ball : basket.getBalls()) {
                if (ball == null) {
                    continue;
                }
                BallColor ballColor = ball.getBallColor();
                if (ballColor.equals(color)) {
                    coloredBalls++;
                }
            }
        }
        return coloredBalls;
    }

    public int countColoredBalls(Basket basket, String color) {
        BallColor ballColor = BallColor.valueOf(color.toUpperCase());
        return countColoredBalls(basket, ballColor);
    }

    private boolean isFull(Basket basket) {
        int freeSpace = basket.getTotalCapacity() - basket.getCurrentSize();
        return freeSpace == 0;
    }

    private boolean isTooHeavy(Basket basket, Ball ball) {
        boolean flag = false;
        int currentWeight = calculateTotalWeight(basket);
        if (currentWeight + ball.getWeight() > basket.getMaxInputWeight()) {
            flag = true;
        }
        return flag;
    }
}
