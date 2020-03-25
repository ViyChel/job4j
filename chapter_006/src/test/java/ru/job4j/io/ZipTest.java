package ru.job4j.io;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.junit.Assert.*;

public class ZipTest {
    private String path = System.getProperty("java.io.tmpdir");
    private String separator = System.getProperty("file.separator");
    File dir = new File(path + separator + "test");
    String[] array = new String[]{"-d", dir.getAbsolutePath(), "-e", "*.java", ".iml", ".txt", "-o", dir + separator + "project.zip"};
    Args arguments = new Args(array);

    @Before
    public void init() {
        dir.mkdir();
    }

    @Test
    public void whenAddToArchiveFile3() throws IOException {
        new File(dir, "file1.java").createNewFile();
        new File(dir, "file2.iml").createNewFile();
        new File(dir, "file3.deb").createNewFile();
        Zip zip = new Zip();
        List<File> listToZip = zip.seekBy(arguments.getDirectory(), arguments.getExcule());
        zip.pack(listToZip, new File(arguments.getOutput()));
        assertEquals(readingArchive(arguments.getOutput()), "/tmp/test/project.zip");

    }

    public String readingArchive(String dir) {
        String name = null;
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(dir))) {
            ZipEntry entry;
            while ((entry = zin.getNextEntry()) != null) {
                name = entry.getName();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }
}