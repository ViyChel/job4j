package ru.job4j.tracker;

import java.util.function.Consumer;

public class FindByIdAction implements UserAction {

    private final Consumer<String> output = System.out::println;

    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, ITracker tracker) {
        boolean result = false;
        String id = input.askStr("Enter Id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            output.accept("=== Item found by Id: " + id + " ===");
            output.accept(item.getId() + " " + item.getName());
            result = true;
        } else {
            output.accept("Item not found!");
        }
        return result;
    }
}
