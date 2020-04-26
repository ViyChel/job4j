package ru.job4j.io;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.junit.Assert.*;

public class AnalizyTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenServerUnavailable() throws IOException {
        Analizy analizy = new Analizy();
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