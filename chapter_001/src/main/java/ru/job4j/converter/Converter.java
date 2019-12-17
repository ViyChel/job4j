package ru.job4j.converter;

public class Converter {

    public static int rubleToEuro(int value) {
        return value / 70;
    }

    public static int rubleToDollar(int value) {
        return value / 60;
    }

    public static int euroToRuble(int value) {
        return value * 70;
    }

    public static int dollarToRuble(int value) {
        return value * 60;
    }

    public static void main(String[] args) {
        int euro = rubleToEuro(140);
        int dollar = rubleToDollar(360);
        int rubleEuro = euroToRuble(10);
        int rubleDollar = dollarToRuble(10);
        System.out.println("140 rubles are " + euro + " euro.");
        System.out.println("360 rubles are " + dollar + " dollars.");
        System.out.println("10 euro are " + rubleEuro + " rubles.");
        System.out.println("10 dollars are " + rubleDollar + " rubles.");

        testRubleToEuro();
        testRubleToDollar();
        testEuroToRuble();
        testDollarToRuble();
    }

    private static void testRubleToEuro() {
        int in = 140;
        int expected = 2;
        int out = rubleToEuro(in);
        boolean passed = expected == out;
        System.out.println("140 rubles are 2. Test result : " + passed);
    }

    private static void testRubleToDollar() {
        int in = 360;
        int expected = 6;
        int out = rubleToDollar(in);
        boolean passed = expected == out;
        System.out.println("360 rubles are 6. Test result : " + passed);
    }

    private static void testEuroToRuble() {
        int in = 10;
        int expected = 700;
        int out = euroToRuble(in);
        boolean passed = expected == out;
        System.out.println("10 euro are 700. Test result : " + passed);
    }

    private static void testDollarToRuble() {
        int in = 10;
        int expected = 600;
        int out = dollarToRuble(in);
        boolean passed = expected == out;
        System.out.println("10 dollars are 600. Test result : " + passed);
    }
}

