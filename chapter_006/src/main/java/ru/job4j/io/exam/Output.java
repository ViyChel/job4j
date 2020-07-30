package ru.job4j.io.exam;

import java.nio.file.Path;
import java.util.List;

/**
 * Interface Output.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 28.07.2020
 */
public interface Output {
    void write(List<Path> files);
}
