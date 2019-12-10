package ru.job4j.array;

/**
 * Class ArrayChar. Класс содержит метод, который проверяет, что слово начинается c определенной последовательности.
 *
 * @author yagufarov
 * @version 1.0
 * @since 10.12.2019
 */

public class ArrayChar {

    public static boolean startsWith(char[] word, char[] pref) {
        for (int i = 0; i < pref.length; i++) {
            if (word[i] != pref[i]) {
                return false;
            }
        }
        return true;
    }
}