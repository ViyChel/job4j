package ru.job4j.sort;

import java.util.Arrays;

/**
 * Class Merge
 * Test task is for the exam "Basic Syntax"
 * @author Vitaly Yagufarov
 * @version 1.0
 * @since 13.12.2019
 */

public class Merge {

    /**
     * Method merge is designed to merge two sorted arrays into one with general sorting.
     * @param left   first array int []
     * @param right  second array int []
     * @return int[] Sorted array after merging two arrays
     */

    public int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int indexLeft = 0;
        int indexRight = 0;

        while (indexLeft + indexRight != result.length) {
            if (indexLeft < left.length && indexRight == right.length) {
                result[indexLeft + indexRight] = left[indexLeft];
                indexLeft++;
            } else if (indexRight < right.length && indexLeft == left.length) {
                result[indexLeft + indexRight] = right[indexRight];
                indexRight++;
            } else {
                if (left[indexLeft] < right[indexRight]) {
                    result[indexLeft + indexRight] = left[indexLeft];
                    indexLeft++;
                } else {
                    result[indexLeft + indexRight] = right[indexRight];
                    indexRight++;
                }
            }
        }
        return result;
    }

    /**
     * Method main for testing the method merge {@link Merge#merge(int[], int[])}
     * @param args The main method accepts a single argument: an array of elements of type String.
     */

    public static void main(String[] args) {
        Merge process = new Merge();
        int[] rsl = process.merge(
                new int[]{1, 3, 5},
                new int[]{2, 4}
        );
        System.out.println(Arrays.toString(rsl));
    }
}
