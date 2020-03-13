package ru.job4j.io;


import java.util.HashSet;
import java.util.Set;

/**
 * Class Args
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 11.03.2020
 */
public class Args {
    private String directory;
    private Set<String> exclude = new HashSet<>();
    private String output;

    /**
     * Instantiates a new Args.
     *
     * @param args the args
     */
    public Args(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-d")) {
                this.directory = args[++i];
            } else if (args[i].equals("-e")) {
                while (!args[i + 1].equals("-o")) {
                    if (args[i + 1].startsWith("*")) {
                        this.exclude.add(args[i + 1].substring(1));
                    } else {
                        this.exclude.add(args[i + 1]);
                    }
                    i++;
                }
            } else if (args[i].equals("-o")) {
                this.output = args[i + 1];
            }
        }
    }

    /**
     * Gets directory.
     *
     * @return the directory
     */
    public String getDirectory() {
        return directory;
    }

    /**
     * Gets excule.
     *
     * @return the excule
     */
    public Set<String> getExcule() {
        return exclude;
    }

    /**
     * Gets output.
     *
     * @return the output
     */
    public String getOutput() {
        return output;
    }
}

