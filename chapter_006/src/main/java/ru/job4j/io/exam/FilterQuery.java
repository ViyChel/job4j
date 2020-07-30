package ru.job4j.io.exam;

import java.nio.file.Path;
import java.util.function.Predicate;

/**
 * Class FilterQuery.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 28.07.2020
 */
public class FilterQuery {

    /**
     * Create query predicate.
     *
     * @param arguments the arguments
     * @return the predicate
     */
    public static Predicate<Path> createQuery(Args arguments) {
        Predicate<Path> result = null;
        String template = arguments.getTemplate();
        String typeSearch = arguments.getType();
        switch (typeSearch) {
            case "-f":
                result = p -> p.toString().endsWith("/" + template);
                break;
            case "-m":
                result = p -> p.toString().endsWith(template.substring(template.lastIndexOf("*") + 1));
                break;
            default:
                break;
        }
        return result;
    }
}
