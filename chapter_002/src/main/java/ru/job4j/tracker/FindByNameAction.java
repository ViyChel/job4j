package ru.job4j.tracker;

import java.util.ArrayList;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        ArrayList<Item> result = tracker.findByName(name);
        if (result.size() > 0) {
            for (Item item : result) {
                System.out.println(item.getId() + " " + item.getName());
            }
        } else {
            System.out.println("Items not found!");
        }
        return true;
    }
}
