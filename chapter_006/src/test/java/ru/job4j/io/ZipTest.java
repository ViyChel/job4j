package ru.job4j.io;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

public class ZipTest {
    private String path = System.getProperty("java.io.tmpdir");
    private String separator = System.getProperty("file.separator");
    File dir = new File(path + separator + System.currentTimeMillis());
    String[] array = new String[]{"-d", dir.getAbsolutePath(), "-o", "*.java", ".iml", ".txt", "-o", dir + separator + "project.zip"};
    Args arguments = new Args(array);

    @Before
    public void init() {
        dir.mkdir();
    }

    @Test
    public void whenAddToArchiveFile() throws IOException {
        File file1 = new File(dir, "file1.java");
        file1.createNewFile();
        Zip zip = new Zip();
        List<File> listToZip = zip.seekBy(arguments.getDirectory(), arguments.getExcule());
        zip.pack(listToZip, new File(arguments.getOutput()));
        List<String> expected = zip.unpack(arguments.getOutput());
        assertEquals(expected.get(0), dir + separator + "file1.java");
        file1.delete();
        Files.delete(Paths.get(dir + separator + "project.zip"));
        dir.deleteOnExit();
    }
}