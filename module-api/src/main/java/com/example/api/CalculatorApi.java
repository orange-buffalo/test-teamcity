package com.example.api;

import com.example.core.MathUtils;

public class CalculatorApi {

    public int add(int a, int b) {
        return MathUtils.add(a, b);
    }

    public int subtract(int a, int b) {
        return MathUtils.subtract(a, b);
    }

    public int multiply(int a, int b) {
        return MathUtils.multiply(a, b);
    }

    public double divide(double a, double b) {
        return MathUtils.divide(a, b);
    }

    public String describeNumber(int n) {
        return n + " is " + (MathUtils.isEven(n) ? "even" : "odd");
    }
}
