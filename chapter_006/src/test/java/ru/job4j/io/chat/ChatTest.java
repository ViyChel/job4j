package ru.job4j.io.chat;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class ChatTest {

    @Test
    public void whenUserAnswerStop() throws IOException {
        File log = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + "log." + System.currentTimeMillis());
        if (!log.createNewFile()) {
            throw new IllegalStateException(String.format("File could not created %s", log.getAbsoluteFile()));
        }
        File source = new File(getClass().getClassLoader().getResource("source.txt").getFile());
        StubInput userInput = new StubInput(new String[]{"Привет", "стоп", "раз", "как дела?", "закончить"});
        new Chat(userInput, log, source).startChat();
        boolean expected = false;
        boolean stop = false;
        try (BufferedReader br = new BufferedReader(new FileReader(log))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals("user: стоп")) {
                    stop = true;
                } else if (stop && line.startsWith("user:")) {
                    expected = true;
                    break;
                }
            }
        }
        assertTrue(expected);
        log.deleteOnExit();
    }

    @Test
    public void whenUserAnswerContinue() throws IOException {
        File log = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + "log." + System.currentTimeMillis());
        if (!log.createNewFile()) {
            throw new IllegalStateException(String.format("File could not created %s", log.getAbsoluteFile()));
        }
        File source = new File(getClass().getClassLoader().getResource("source.txt").getFile());
        StubInput userInput = new StubInput(new String[]{"Привет", "стоп", "раз", "как дела?", "продолжить", "закончить"});
        new Chat(userInput, log, source).startChat();
        boolean expected = false;
        boolean stop = false;
        boolean botContinue = false;
        try (BufferedReader br = new BufferedReader(new FileReader(log))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals("user: стоп")) {
                    stop = true;
                    botContinue = false;
                } else if (stop && line.equals("user: продолжить")) {
                    botContinue = true;
                    stop = false;
                } else if (botContinue) {
                    expected = true;
                }
            }
        }
        assertTrue(expected);
        log.deleteOnExit();
    }
}