package com.anton.day3.parser;

import com.anton.day3.exception.BasketValidatorException;
import com.anton.day3.validator.NumberValidator;

public class BasketParser {
    private static final int MAX_CAPACITY = 50;
    private static final int MIN_CAPACITY = 0;
    private static final double MAX_INPUT_WEIGHT = 1000;
    private static final double MIN_INPUT_WEIGHT = 0;

    private NumberValidator validator = new NumberValidator();

    public int parseCapacity(String capacity) throws BasketValidatorException {
        boolean isInt = validator.isValidInt(capacity);
        if (!isInt) {
            throw new BasketValidatorException();
        }
        int proposedCapacity = Integer.parseInt(capacity);
        if (proposedCapacity > MAX_CAPACITY || proposedCapacity < MIN_CAPACITY) {
            throw new BasketValidatorException();
        }
        return proposedCapacity;
    }

    public double parseWeight(String weight) throws BasketValidatorException {
        boolean isDouble = validator.isValidDouble(weight);
        if (!isDouble) {
            throw new BasketValidatorException();
        }
        double proposedWeight = Double.parseDouble(weight);
        if (proposedWeight > MAX_INPUT_WEIGHT || proposedWeight < MIN_INPUT_WEIGHT) {
            throw new BasketValidatorException();
        }
        return proposedWeight;
    }
}
