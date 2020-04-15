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
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private static final String FINISH = "закончить";
    private static final String USER = "user: ";
    private static final String BOT = "bot: ";
    private File log;
    private File source;
    private final Input input;

    public Chat(Input input, File log, File source) {
        this.input = input;
        this.log = log;
        this.source = source;
    }

    /**
     * Start chat.
     */
    public void startChat() {
        try (PrintWriter out = new PrintWriter(log)) {
            boolean stopMarker = false;
            String line;
            List<String> botAnswers = readBotAnswersFile(source);
            List<String> logList = new ArrayList<>();
            do {
                System.out.print(USER);
                line = input.askUser();
                logList.add(USER + line);
                if (line.equals(STOP)) {
                    stopMarker = true;
                    continue;
                } else if (line.equals(CONTINUE) && stopMarker) {
                    stopMarker = false;
                }
                if (!line.equals(FINISH) && !stopMarker) {
                    String bot = botAnswer(botAnswers);
                    System.out.println(bot);
                    logList.add(bot);
                }
            } while (!line.equals(FINISH));
            logList.forEach(out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> readBotAnswersFile(File source) {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            reader.lines().forEach(line -> Collections.addAll(result, line.split(" ")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private String botAnswer(List<String> list) {
        int countWords = (int) (Math.random() * 10);
        int cellNumber = (int) (Math.random() * list.size() - 10);
        StringBuilder result = new StringBuilder(list.get(cellNumber));
        for (int i = cellNumber + 1; i < cellNumber + countWords; i++) {
            result.append(" ").append(list.get(i));
        }
        return BOT + result.toString();
    }

    public static void main(String[] args) {
        ConsoleInput input = new ConsoleInput();
        Chat chat = new Chat(input, input.getLog(), input.getSource());
        chat.startChat();
    }
}

