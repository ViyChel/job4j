package ru.job4j.io;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class ArgsTest {

    private String[] array;
    private Args args;

    @Before
    public void init() {
        array = new String[]{"-d", "./chapter_005", "-e", "*.java", ".iml", ".txt", "-o", "project.zip"};
        args = new Args(array);
    }

    @Test
    public void getDirectory() {
        String expected = args.getDirectory();
        assertEquals(expected, "./chapter_005");
    }

    @Test
    public void getExcule() {
        Set<String> expected = args.getExcule();
        assertEquals(expected, Set.of(".iml", ".java", ".txt"));
    }

    @Test
    public void getOutput() {
        String expected = args.getOutput();
        assertEquals(expected, "project.zip");
    }
}