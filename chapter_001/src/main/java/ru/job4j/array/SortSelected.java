package ru.job4j.array;

/**
 * Class SortSelected.
 *
 * @author Yagufarov
 * @version 1.0
 * @since 10.12.2019
 */

public class SortSelected {

    /**
     * Method sort сортирует массив по возрастанию методом выборки
     *
     * @param data массив чисел, который нужно отсортировать по возрастанию
     * @return возвращаем отсортированый по возрастанию массив int[]
     */

    public static int[] sort(int[] data) {

        for (int i = 0; i < data.length; i++) {
            int min = MinDiapason.findMin(data, i, data.length - 1);
            int index = FindLoop.indexOf(data, min, i, data.length - 1);
            data[index] = data[i];
            data[i] = min;
        }
        return data;
    }
}