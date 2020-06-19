package com.anton.day3.validator;

import com.anton.day3.exception.BasketValidatorException;
import com.anton.day3.validator.parser.NumberParser;

public class BasketValidator {
    private static final int MAX_CAPACITY = 50;
    private static final int MIN_CAPACITY = 0;
    private static final double MAX_INPUT_WEIGHT = 1000;
    private static final double MIN_INPUT_WEIGHT = 0;

    private NumberParser parser = new NumberParser();

    public Integer validateCapacity(String capacity) throws BasketValidatorException {
        boolean isInt = parser.isValidInt(capacity);
        if (!isInt) {
            throw new BasketValidatorException();
        }
        int proposedCapacity = Integer.parseInt(capacity);
        if (proposedCapacity > MAX_CAPACITY || proposedCapacity < MIN_CAPACITY) {
            throw new BasketValidatorException();
        }
        return proposedCapacity;
    }

    public double validateWeight(String weight) throws BasketValidatorException {
        boolean isDouble = parser.isValidDouble(weight);
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
