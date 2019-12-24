package ru.job4j.strategy;

public class Square implements Shape {
    @Override
    public String draw() {
        String s = System.lineSeparator();
        return new StringBuilder()
                .append("++++++++").append(s)
                .append("+      +").append(s)
                .append("+      +").append(s)
                .append("++++++++").append(s)
                .toString();
    }
}
