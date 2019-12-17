package ru.job4j.condition;

public class TriangleArea {
    public static double area(double a, double b, double c) {
        double halfPerimeter = (a + b + c) / 2;
        double triangleArea = Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
        return triangleArea;
    }

    public static void main(String[] args) {
        double result = TriangleArea.area(2, 2, 2);
        System.out.println("area (2, 2, 2) = " + result);
    }
}
