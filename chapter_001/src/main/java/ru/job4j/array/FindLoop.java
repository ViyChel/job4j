package ru.job4j.array;

/**
 * Class FindLoop. Содержит методы для поиска в массивах.
 *
 * @author Yagufarov
 * @version 1.1
 * @since 10.12.2019
 */

public class FindLoop {

    /**
     * Method indexOf. Осуществляет поиск элемента в массиве.
     * @param data массив в котором делаем поиск
     * @param el число которое ищем
     * @return возвращаем индекс массива в котором найден элемент, либо -1 если элемент не найден.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                return index;
            }
        }
        return rst;
    }

    /**
     * Method indexOf. Осуществляет поиск в заданном диапазоне массива.
     * @param data массив в котором делаем поиск
     * @param el   число которое ищем
     * @param start индекс массива с которого начинаем искать
     * @param finish индекс массива в котором заканчиваем поиск
     * @return возвращаем индекс массива в котором найден элемент, либо -1 если элемент не найден.
     */

    public static int indexOf(int[] data, int el, int start, int finish) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = start; index <= finish; index++) {
            if (data[index] == el) {
                return index;
            }
        }
        return rst;
    }
}
