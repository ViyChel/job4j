package ru.job4j.tracker;

import java.util.List;
import java.util.function.Consumer;

public class FindByNameAction implements UserAction {

    private final Consumer<String> output = System.out::println;

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, ITracker tracker) {
        boolean result = false;
        String name = input.askStr("Enter name: ");
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (Item item : items) {
                output.accept(item.getId() + " " + item.getName());
                result = true;
            }
        } else {
            output.accept("Items not found!");
        }
        return result;
    }
}
