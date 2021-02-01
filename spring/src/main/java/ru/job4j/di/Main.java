package ru.job4j.di;

/**
 * Class Main.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 01.02.2021
 */
public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        context.reg(Store.class);
        context.reg(ConsoleInput.class);
        context.reg(StartUI.class);

        StartUI ui = context.get(StartUI.class);

        ui.add(ui.input("Введите ФИО: "));
        ui.add("Petr Arsentev");
        ui.add("Ivan ivanov");
        ui.print();
    }
}