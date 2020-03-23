package ru.job4j.io.exam;

import java.io.IOException;
import java.nio.file.*;
import java.util.function.Predicate;

/**
 * Class FileSearch
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 20.03.2020
 */

public class FileSearch {

    public static void search(String root, Predicate<String> predicate, String output) throws IOException {
        Files.walkFileTree(Paths.get(root), new PrintFiles(predicate, output));
    }

    private static Predicate<String> createQuery(String template, Boolean mask, Boolean fullName) {
        Predicate<String> result = null;
        if (mask) {
            String tmp = template.substring(template.lastIndexOf("*") + 1);
            result = s -> s.endsWith(tmp);
        } else if (fullName) {
            result = s -> s.endsWith("/" + template);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Args arguments = new Args(args);
        FileSearch.search(arguments.getDirectory(),
                createQuery(arguments.getTemplate(), arguments.isMask(), arguments.isFullName()), arguments.getOutput());
    }
}

