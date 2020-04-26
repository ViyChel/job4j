package ru.job4j.io.chat;

public class StubInput implements Input {

    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String askUser() {
        return answers[position++];
    }
}
