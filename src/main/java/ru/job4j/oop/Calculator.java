package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int b) {
        return x - b;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int c) {
        return x / c;
    }

    public int sumAllOperation(int d) {
        return sum(d) + minus(d) + this.multiply(d) + this.divide(d);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(sum(1));
        System.out.println(minus(1));
        System.out.println(calculator.multiply(1));
        System.out.println(calculator.divide(1));
        System.out.println(calculator.sumAllOperation(1));
    }
}
