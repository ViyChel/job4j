package ru.job4j.io.chat;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class Chat
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 15.03.2020
 */
public class Chat {
    public File log = new File("log.txt");
    private File source = new File(getClass().getClassLoader().getResource("source.txt").getFile());

    /**
     * Start chat.
     */
    public void startChat() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new FileWriter(log))) {
            boolean stopMarker = false;
            String line;
            do {
                System.out.print("user: ");
                line = reader.readLine();
                writer.write("user: " + line);
                writer.newLine();
                if (line.equals("стоп")) {
                    stopMarker = true;
                    continue;
                } else if (line.equals("продолжить") && stopMarker) {
                    stopMarker = false;
                }
                if (!line.equals("закончить") && !stopMarker) {
                    String bot = botAnswer();
                    System.out.println(bot);
                    writer.write(bot);
                    writer.newLine();
                }
            } while (!line.equals("закончить"));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private String botAnswer() throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            while (reader.ready()) {
                String line = reader.readLine();
                Collections.addAll(lines, line.split(" "));
            }
        }
        int countWords = (int) (Math.random() * 10);
        int cellNumber = (int) (Math.random() * lines.size() - 10);
        StringBuilder result = new StringBuilder(lines.get(cellNumber));
        for (int i = cellNumber + 1; i < cellNumber + countWords; i++) {
            result.append(" ").append(lines.get(i));
        }
        return "bot: " + result.toString();
    }

    public static void main(String[] args) throws IOException {
        Chat chat = new Chat();
        chat.startChat();
    }
}

