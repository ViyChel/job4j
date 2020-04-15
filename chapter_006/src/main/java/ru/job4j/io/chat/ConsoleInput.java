package ru.job4j.io.chat;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput implements Input {
    private File log = new File("log.txt");
    private File source = new File(getClass().getClassLoader().getResource("source.txt").getFile());
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public File getLog() {
        return log;
    }

    public File getSource() {
        return source;
    }

    @Override
    public String askUser() {
        String result = null;
        try {
            result = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
