package org.technosoft.service;

public class CalculatorImpl implements Calculator {
    @Override
    public double calculateFees(int clubID) {
        return switch (clubID) {
            case 1 -> 900.0;
            case 2 -> 950.0;
            case 3 -> 1_000.0;
            default -> -1.0;
        };
    }
}

