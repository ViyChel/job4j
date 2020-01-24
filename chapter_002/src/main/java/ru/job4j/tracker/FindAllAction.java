package ru.job4j.tracker;

import java.util.function.Consumer;

public class FindAllAction implements UserAction {

    private final Consumer<String> output = System.out::println;

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        for (Item item : tracker.findAll()) {
            output.accept(String.format("%s %s", item.getId(), item.getName()));
        }
        return true;
    }
}
