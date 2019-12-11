package ru.job4j.array;

/**
 * Class Defragment производит сортировку массива
 *
 * @author Yagufarov
 * @version 1.0
 * @since 11.12.2019
 */

public class Defragment {

    /**
     * Method compress перемещает пустые элементы в конец массива
     *
     * @param array массив, в котором производятся сортировка
     * @return отсортированный массив
     */

    public static String[] compress(String[] array) {
        for (int index = 0; index < array.length; index++) {
            String cell = array[index];
            if (cell == null) {
                // переместить первую не null ячейку
                // Здесь нужен цикл while
                int count = index;
                while (count < array.length - 1) {
                    if (array[count + 1] != null) {
                        array[index] = array[count + 1];
                        array[count + 1] = null;
                        break;
                    }
                    count++;
                }
            }
            System.out.print(array[index] + " ");
        }
        return array;
    }

    public static void main(String[] args) {
        String[] input = {"I", null, "wanna", null, "be", null, "compressed"};
        String[] compressed = compress(input);
        System.out.println();
        for (int index = 0; index < compressed.length; index++) {
            System.out.print(compressed[index] + " ");
        }
    }
}