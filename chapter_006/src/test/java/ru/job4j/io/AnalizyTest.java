package ru.job4j.io;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class AnalizyTest {
    private Analizy analizy;

    @Before
    public void init() {
        analizy = new Analizy();
    }

    @Test
    public void whenServerUnavailable() {
        String source = "./data/server.log";
        String target = "./data/unavailable.csv";
        analizy.unavailable(source, target);
        try (Scanner scanner = new Scanner(new File(target))) {
            while (scanner.hasNext()) {
                assertEquals(scanner.nextLine(), "10:57:01;10:59:01");
                assertEquals(scanner.nextLine(), "11:01:02;11:02:02");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}