package ru.job4j.io.exam;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * Class FileOutput.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 28.07.2020
 */
public class FileOutput implements Output {
    private String output;

    /**
     * Instantiates a new File output.
     *
     * @param output the output
     */
    public FileOutput(String output) {
        this.output = output;
    }

    @Override
    public void write(List<Path> files) {
        try (final FileWriter writer = new FileWriter(output)) {
            for (Path path : files) {
                writer.write(path.toString() + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
