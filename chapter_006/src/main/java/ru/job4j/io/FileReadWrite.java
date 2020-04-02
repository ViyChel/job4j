package ru.job4j.io;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileReadWrite {
    private static final String SP = "=";
    private final String path;
    private final Map<String, String> settings = new LinkedHashMap<>();

    public FileReadWrite(String path) {
        this.path = path;
    }

    public FileReadWrite load() {
        this.settings.clear();
        try (BufferedReader file = new BufferedReader(new FileReader(this.path))) {
            file.lines().forEach(
                    line -> {
                        if (line.contains(SP)) {
                            int pos = line.indexOf(SP);
                            settings.put(line.substring(0, pos), line.substring(pos + 1));
                        } else {
                            settings.put(line, "");
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    public void save() {
        try (final PrintWriter file = new PrintWriter(this.path)) {
            this.settings.forEach(
                    (key, value) -> {
                        file.append(key);
                        if (!value.isEmpty()) {
                            file.append(SP).append(value);
                        }
                        file.println();
                    }
            );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
