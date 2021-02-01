package ru.job4j.di;

/**
 * Class StartUI.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 01.02.2021
 */
public class StartUI {

    private Store store;
    private ConsoleInput input;

    public StartUI(Store store, ConsoleInput input) {
        this.store = store;
        this.input = input;
    }

    public void add(String value) {
        store.add(value);
    }

    public void print() {
        for (String value : store.getAll()) {
            System.out.println(value);
        }
    }

    public String input(String question) {
        return input.askStr(question);
    }
}