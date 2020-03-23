package ru.job4j.io.exam;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.Predicate;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * Class PrintFiles
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 20.03.2020
 */

public class PrintFiles extends SimpleFileVisitor<Path> {
    private Predicate<String> predicate;
    private String output;
    private FileWriter writer;


    public PrintFiles(Predicate<String> predicate, String output) {
        this.predicate = predicate;
        this.output = output;
        try {
            writer = new FileWriter(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (predicate.test(file.toString())) {
            writer.write(file.toString() + System.lineSeparator());
            writer.flush();
        }
        return CONTINUE;
    }
}

