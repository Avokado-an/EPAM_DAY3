package com.anton.day3.creator;

import com.anton.day3.entity.Basket;
import com.anton.day3.exception.BasketValidatorException;
import com.anton.day3.validator.BasketValidator;

public class BasketCreator {
    public Basket createBasket(String totalCapacity, String totalWeight) throws BasketValidatorException {
        BasketValidator validator = new BasketValidator();
        int capacity = validator.validateCapacity(totalCapacity);
        double weight = validator.validateWeight(totalWeight);
        return new Basket(capacity, weight);
    }
}
