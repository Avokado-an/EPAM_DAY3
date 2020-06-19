package com.anton.day3.entity;

public enum BallColor {
    RED("red"),
    BLUE("blue"),
    ORANGE("orange"),
    YELLOW("yellow"),
    GREEN("green");

    private String name;

    BallColor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
