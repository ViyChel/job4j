package ru.job4j.tracker;

import java.beans.PropertyEditorSupport;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, ITracker tracker) {
        String id = input.askStr("Enter Id: ");
        return tracker.deleteItem(id);
    }
}
