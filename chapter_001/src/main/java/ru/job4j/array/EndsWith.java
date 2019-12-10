package ru.job4j.array;

/**
 * Class EndsWith. Класс содержит метод, который проверяет, что слово заканчивается c определенной последовательностью.
 *
 * @author yagufarov
 * @version 1.0
 * @since 10.12.2019
 */

public class EndsWith {
    public static boolean endsWith(char[] word, char[] post) {
        // проверить. что массив word имеет последние элементы одинаковые с post
        for (int i = 0; i < post.length; i++) {
            if (post[post.length - 1] != word[word.length - 1]) {
                return false;
            }
        }
        return true;
    }
}