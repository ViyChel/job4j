package ru.job4j.array;

/**
 * Class MinDiapason. Для поиска минимального числа в заданном диапазоне массива.
 *
 * @author Yagufarov
 * @version 1.0
 * @since 10.12.2019
 */

class MinDiapason {

    /**
     * Method findMin. Ищет минимальное число в заданном диапазоне массива.
     *
     * @param array  массив в котором ищем минимальное число
     * @param start  индекс массива с которого начинаем поиск
     * @param finish индекс массива которым заказнчиваем поиск
     * @return вовращаем минимальное число
     */
    static int findMin(int[] array, int start, int finish) {
        int min = array[start];
        for (int i = start; i <= finish; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }
}
