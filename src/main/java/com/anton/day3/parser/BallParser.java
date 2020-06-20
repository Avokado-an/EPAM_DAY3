package com.anton.day3.parser;

import com.anton.day3.entity.BallColor;
import com.anton.day3.exception.BallValidatorException;
import com.anton.day3.validator.NumberValidator;

public class BallParser {
    private static final double MAX_WEIGHT = 50;
    private static final double MIN_WEIGHT = 0;

    public double parseWeight(String weight) throws BallValidatorException {
        NumberValidator validator = new NumberValidator();
        boolean isDouble = validator.isValidDouble(weight);
        if (!isDouble) {
            throw new BallValidatorException();
        }
        double res = Double.parseDouble(weight);
        if (res > MAX_WEIGHT || res < MIN_WEIGHT) {
            throw new BallValidatorException();
        }
        return res;
    }

    public BallColor parseColor(String color) throws BallValidatorException {
        if (color == null) {
            throw new BallValidatorException();
        }
        try {
            return BallColor.valueOf(color.toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new BallValidatorException();
        }
    }
}
