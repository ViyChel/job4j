package ru.job4j.io;

import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;


import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.*;

public class AnalizyTest {
    private Analizy analizy;

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

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

    @Test
    public void testWithTemporaryFolder() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("500 13:56:01");
            out.println("300 14:57:01");
            out.println("400 15:58:01");
            out.println("500 20:59:01");
            out.println("200 22:01:02");
            out.println("100 23:02:02");
        }
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            reader.lines().map(el -> el + " ").forEach(rsl::append);
        }
        assertEquals(rsl.toString(), "13:56:01;14:57:01 15:58:01;22:01:02 ");
    }
}