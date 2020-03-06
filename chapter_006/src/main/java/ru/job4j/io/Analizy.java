package ru.job4j.io;

import java.io.*;

/**
 * Class Analizy
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 07.03.2020
 */
public class Analizy {
    /**
     * Unavailable.
     *
     * @param source the source
     * @param target the target
     */
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
            String start = null;
            while (reader.ready()) {
                String data = reader.readLine();
                if (start == null && (data.startsWith("400") || data.startsWith("500"))) {
                    writer.write(data.split(" ")[1] + ";");
                    start = data;
                } else if (start != null && (!data.isEmpty() && !data.startsWith("400") && !data.startsWith("500"))) {
                    writer.write(data.split(" ")[1]);
                    writer.newLine();
                    start = null;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

