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
        String name = input.askStr("Enter name: ");
        List<Item> result = tracker.findByName(name);
        if (result.size() > 0) {
            for (Item item : result) {
                output.accept(item.getId() + " " + item.getName());
            }
        } else {
            output.accept("Items not found!");
        }
        return true;
    }
}
