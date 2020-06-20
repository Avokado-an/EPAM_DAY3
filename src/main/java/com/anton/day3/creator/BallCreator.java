package com.anton.day3.creator;

import com.anton.day3.entity.Ball;
import com.anton.day3.entity.BallColor;
import com.anton.day3.exception.BallValidatorException;
import com.anton.day3.parser.BallParser;

public class BallCreator {
    public Ball createBall(String weight, String color) throws BallValidatorException {
        BallParser parser = new BallParser();
        double ballWeight = parser.parseWeight(weight);
        BallColor ballColor = parser.parseColor(color);
        return new Ball(ballWeight, ballColor);
    }
}
