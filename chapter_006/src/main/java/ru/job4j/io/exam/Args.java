package ru.job4j.io.exam;

import java.util.HashSet;
import java.util.Set;

/**
 * Class Args
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 20.03.2020
 */
public class Args {
    private String directory;
    private String template;
    private Set<String> exclude = new HashSet<>();
    private String output;
    private boolean mask;
    private boolean fullName;

    /**
     * Instantiates a new Args.
     *
     * @param args the args
     */
    public Args(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-d")) {
                this.directory = args[++i];
            } else if (args[i].equals("-n")) {
                this.template = args[++i];
            } else if (args[i].equals("-m")) {
                this.mask = true;
            } else if (args[i].equals("-f")) {
                this.fullName = true;
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

    /**
     * Gets template.
     *
     * @return the template
     */
    public String getTemplate() {
        return template;
    }

    /**
     * Is mask boolean.
     *
     * @return the boolean
     */
    public boolean isMask() {
        return mask;
    }

    /**
     * Is full name boolean.
     *
     * @return the boolean
     */
    public boolean isFullName() {
        return fullName;
    }
}

