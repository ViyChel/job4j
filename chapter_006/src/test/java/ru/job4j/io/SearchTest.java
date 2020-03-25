package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class SearchTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void printFiles() throws IOException {
        String path = System.getProperty("java.io.tmpdir");
        folder.newFile("file1.abc");
        folder.newFile("file2.abc");
        folder.newFile("file3.deb");
        Search search = new Search();
        File sourceFile = new File(path);
        List<File> expected = search.files(sourceFile.getAbsolutePath(), s -> s.endsWith(".abc"));
        String listFiles = "";
        for (File f : expected) {
            listFiles = listFiles + f.getName() + " ";
        }
        assertEquals(listFiles, "file2.abc file1.abc ");
    }
}