package ru.job4j.array;

/**
 * Class Check. Проверяет, что все элементы в массиве являются или true или false.
 *
 * @author yagufarov
 * @version 1.0
 * @since 10.12.2019
 */

public class Check {
    public boolean mono(boolean[] data) {
        boolean etalon = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] != etalon) {
                return false;
            }
        }
        return true;
    }
}
