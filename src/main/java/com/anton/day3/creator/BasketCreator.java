package com.anton.day3.creator;

import com.anton.day3.entity.Basket;
import com.anton.day3.exception.BasketValidatorException;
import com.anton.day3.parser.BasketParser;

public class BasketCreator {
    public Basket createBasket(String totalCapacity, String totalWeight) throws BasketValidatorException {
        BasketParser parser = new BasketParser();
        int capacity = parser.parseCapacity(totalCapacity);
        double weight = parser.parseWeight(totalWeight);
        return new Basket(capacity, weight);
    }
}
