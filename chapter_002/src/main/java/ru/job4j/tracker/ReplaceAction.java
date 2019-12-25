package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            item.setName(input.askStr("Enter a new name of item: "));
            item.setId(id);
            tracker.replace(id, item);
        } else {
            System.out.println("Invalid id of item selected!");
        }
        return true;
    }
}
