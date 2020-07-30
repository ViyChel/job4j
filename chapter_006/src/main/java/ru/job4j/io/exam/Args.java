package ru.job4j.io.exam;

/**
 * Class Args
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 20.03.2020
 */
public class Args {
    private String[] args;
    private String directory;
    private String template;
    private Output output;
    private String type;

    /**
     * Instantiates a new Args.
     *
     * @param args the args
     */
    public Args(String[] args) {
        this.args = args;
    }

    /**
     * Init.
     */
    public void init() {
        if (args.length == 7 && args[0].equals("-d") && args[2].equals("-n") && args[5].equals("-o")) {
            this.directory = args[1];
            this.template = args[3];
            this.type = args[4];
            this.output = new FileOutput(args[6]);
        } else {
            throw new IllegalArgumentException("Invalid args count! Try again, e.g. java -jar find.jar -d c:/ -n *"
                    + ".txt -m -o log.txt");
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
     * Gets output.
     *
     * @return the output
     */
    public Output getOutput() {
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
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }
}

