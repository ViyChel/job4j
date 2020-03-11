package ru.job4j.io;


import java.io.File;
import java.util.*;
import java.util.function.Predicate;

/**
 * Class Search
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 07.03.2020
 */
public class Search {

    /**
     * Files list.
     *
     * @param parent    the parent
     * @param condition the condition
     * @return the list
     */
    List<File> files(String parent, Predicate<String> condition) {
        List<File> result = new ArrayList<>();
        Queue<File> list = new LinkedList<>();
        list.offer(new File(parent));
        while (!list.isEmpty()) {
            File file = list.poll();
            if (file.isDirectory() && file.canRead()) {
                list.addAll(Arrays.asList(file.listFiles()));
            } else if (condition.test(file.getName())) {
                result.add(file);
            }
        }
        return result;
    }
}

