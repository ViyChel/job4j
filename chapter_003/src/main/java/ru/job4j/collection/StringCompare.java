package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        char[] leftStr = left.toCharArray();
        char[] rightStr = right.toCharArray();
        int indexLeft = 0;
        int indexRight = 0;

        while (true) {
            if (indexLeft == leftStr.length && indexRight == rightStr.length) {
                break;
            } else if (leftStr.length == 0 || (indexLeft == leftStr.length && indexRight < rightStr.length)) {
                result = -1;
                break;
            } else if (rightStr.length == 0 || (indexRight == rightStr.length && indexLeft < leftStr.length)) {
                result = 1;
                break;
            }
            int temp = Character.compare(leftStr[indexLeft], rightStr[indexRight]);
            indexLeft++;
            indexRight++;
            if (temp != 0) {
                result = temp;
                break;
            }
        }
        return result;
    }
}
