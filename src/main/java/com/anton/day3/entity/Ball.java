package com.anton.day3.entity;

public class Ball {
    private double weight;
    private BallColor ballColor;

    public Ball(double weight, BallColor ballColor) {
        this.weight = weight;
        this.ballColor = ballColor;
    }

    public Ball() {
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public BallColor getBallColor() {
        return ballColor;
    }

    public void setBallColor(BallColor ballColor) {
        this.ballColor = ballColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ball)) {
            return false;
        }
        Ball ball = (Ball) o;
        return getWeight() == ball.getWeight() &&
                getBallColor().equals(ball.getBallColor());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Double.valueOf(weight).hashCode();
        if (ballColor != null)
            result = 31 * result + ballColor.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s Ball: %.1f", ballColor.getName(), weight);
    }
}
