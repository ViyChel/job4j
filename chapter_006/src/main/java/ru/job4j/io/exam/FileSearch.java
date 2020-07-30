package ru.job4j.io.exam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Predicate;

/**
 * Class FileSearch
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 20.03.2020
 */
public class FileSearch {

    /**
     * Search.
     *
     * @param root      the root
     * @param predicate the predicate
     * @param output    the output
     * @throws IOException the io exception
     */
    public static void search(String root, Predicate<Path> predicate, Output output) throws IOException {
        SearchPath searchPath = new SearchPath(predicate);
        Files.walkFileTree(Paths.get(root), searchPath);
        output.write(searchPath.getFiles());
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {
        Args arguments = new Args(args);
        arguments.init();
        FileSearch.search(arguments.getDirectory(), FilterQuery.createQuery(arguments), arguments.getOutput());
    }
}

