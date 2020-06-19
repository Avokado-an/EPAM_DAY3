package com.anton.day3.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Basket {
    private static final int DEFAULT_CAPACITY = 10;
    private static final double DEFAULT_MAX_WEIGHT = 150;

    private int totalCapacity = DEFAULT_CAPACITY;
    private double maxInputWeight = DEFAULT_MAX_WEIGHT;
    private List<Ball> balls;

    public Basket(int totalCapacity, double maxInputWeight) {   //дилит
        balls = new ArrayList<Ball>(totalCapacity);
        this.totalCapacity = totalCapacity;
        this.maxInputWeight = maxInputWeight;
    }

    public Basket() {
        balls = new ArrayList<Ball>(totalCapacity);
    }

    public Basket(List<Ball> balls) {
        this.balls = balls;
    }

    public void addBall(Ball ball) {
        balls.add(ball);
    }

    public Ball getBall(int index) {
        return balls.get(index);
    }

    public void removeBall(int index) {
        balls.remove(index);
    }

    public int getCurrentSize() {
        return balls.size();
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(Integer totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public double getMaxInputWeight() {
        return maxInputWeight;
    }

    public void setMaxInputWeight(double maxInputWeight) {
        this.maxInputWeight = maxInputWeight;
    }

    public List<Ball> getBalls() {
        return Collections.unmodifiableList(balls);
    }

    public void setBalls(List<Ball> balls) {
        this.balls = balls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Basket)) {
            return false;
        }
        Basket basket = (Basket) o;
        return getTotalCapacity() == basket.getTotalCapacity() &&
                Double.compare(getMaxInputWeight(), basket.getMaxInputWeight()) == 0 &&
                getBalls().equals(basket.getBalls());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + totalCapacity;
        result = 31 * result + Double.valueOf(maxInputWeight).hashCode();
        if (balls != null)
            result = 17 * result + balls.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("Basket (total capacity - %d; max weight - %.1f): %n%s", totalCapacity,
                maxInputWeight, ballsToString().toString());
    }

    private StringBuilder ballsToString() {
        StringBuilder res = new StringBuilder();
        for (Ball ball : balls) {
            if (ball != null) {
                res.append("\t").append(ball.toString()).append("\n");
            }
        }
        return res;
    }
}
