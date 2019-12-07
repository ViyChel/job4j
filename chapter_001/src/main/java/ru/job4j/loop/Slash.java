package ru.job4j.loop;

/**
 * Class Slash. Построение таблицы с индексами в консоли в виде креста.
 * @author yagufarov
 * @since 07.12.2019
 * @version 1.0
 */

public class Slash {
    public static void draw(int size) {
        for (int row = 0; row < size; row++) {
            for (int cell = 0; cell < size; cell++) {
                boolean left = row == cell; // добавить условие, по которому нужно определить ставить ли символ или нет.
                boolean right = cell == size - 1 - row; // добавить условие, что нужно ставить элемент в правый угол.
                if (left) {
                    System.out.print("0");
                } else if (right) {
                    System.out.print("0");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Draw by 3");
        draw(3);
        System.out.println("Draw by 5");
        draw(5);
    }
}
