package ru.job4j.io.exam;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * Class PrintFiles
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 20.03.2020
 */
public class SearchPath extends SimpleFileVisitor<Path> {
    private Predicate<Path> predicate;
    private List<Path> files;

    /**
     * Instantiates a new Search path.
     *
     * @param predicate the predicate
     */
    public SearchPath(Predicate<Path> predicate) {
        this.predicate = predicate;
        this.files = new ArrayList<>();
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (predicate.test(file)) {
            files.add(file);
        }
        return CONTINUE;
    }

    /**
     * Gets files.
     *
     * @return the files
     */
    public List<Path> getFiles() {
        return files;
    }
}

