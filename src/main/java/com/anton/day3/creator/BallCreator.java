package com.anton.day3.creator;

import com.anton.day3.entity.Ball;
import com.anton.day3.entity.BallColor;
import com.anton.day3.exception.BallValidatorException;
import com.anton.day3.validator.BallValidator;

public class BallCreator {
    public Ball createBall(String weight, String color) throws BallValidatorException {
        BallValidator validator = new BallValidator();
        double ballWeight = validator.validateWeight(weight);
        BallColor ballColor = validator.validateColor(color);
        return new Ball(ballWeight, ballColor);
    }
}
