package com.anton.day3.validator;

public class NumberValidator {
    public boolean isValidInt(String number) {
        boolean flag = true;
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            flag = false;
        }
        return flag;
    }

    public boolean isValidDouble(String number) {
        boolean flag = true;
        try {
            Double.parseDouble(number);
        } catch (NumberFormatException e) {
            flag = false;
        } catch (NullPointerException e) {
            flag = false;
        }
        return flag;
    }
}
