package ru.job4j.inheritance;

public class JSONReport extends TextReport {

    public String generate(String name, String body) {
        return "{" + "\n"
                + "name : " + name + "\n"
                + "body : " + body + "\n"
                + "}";
    }
}
