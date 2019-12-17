package ru.job4j.array;

/**
 * Class Min. Содержит метод для поиска минимального числа в массиве.
 *
 * @author Yagufarov
 * @version 1.0
 * @since 10.12.2019
 */

class Minimum {

    /**
     * Method findMin. Ищет минимальное число в массиве.
     *
     * @param array массив в котором производится поиск.
     * @return возвращаем минимальное число массива.
     */
    static int findMin(int[] array) {
        int min = array[0];
        for (int index = array.length - 1; index >= 0; index--) {
            // проверить, что эталон больше, чем элемент. записать в эталон элемент массива.
            if (min > array[index]) {
                min = array[index];
            }
        }
        return min;
    }
}
