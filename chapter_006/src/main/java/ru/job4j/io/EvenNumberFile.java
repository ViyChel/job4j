package ru.job4j.io;

import java.io.*;

/**
 * Class EvenNumberFile
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 19.03.2020
 */
public class EvenNumberFile {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("even.txt"))) {
            while (reader.ready()) {
                int number = Integer.parseInt(reader.readLine());
                if (number % 2 == 0) {
                    System.out.println(number + " четное число");
                } else {
                    System.out.println(number + " нечетное число");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

