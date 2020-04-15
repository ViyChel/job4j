package ru.job4j.tracker;

import java.util.function.Consumer;

public class StartUI {

    private final Input input;
    private final ITracker tracker;
    private final Consumer<String> output;

    public StartUI(Input input, ITracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, output);
        boolean run = true;
        while (run) {
            menu.showMenu();
            int select = input.askInt("Select: ", menu.getActions().size());
            UserAction action = menu.getActions().get(select);
            run = action.execute(input, tracker);
        }
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::println).init();
    }
}