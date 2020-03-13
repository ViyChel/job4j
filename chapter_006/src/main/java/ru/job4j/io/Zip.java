package ru.job4j.io;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Class Zip
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 11.03.2020
 */
public class Zip {
    /**
     * Pack.
     *
     * @param sources the sources
     * @param target  the target
     */
    public void pack(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File source : sources) {
                zip.putNextEntry(new ZipEntry(source.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Seek by list.
     *
     * @param root the root
     * @param ext  the ext
     * @return the list
     */
    public List<File> seekBy(String root, Set<String> ext) {
        List<File> result = new ArrayList<>();
        Queue<File> list = new LinkedList<>();
        list.offer(new File(root));
        while (!list.isEmpty()) {
            File file = list.poll();
            if (file.isDirectory() && file.canRead()) {
                list.addAll(Arrays.asList(file.listFiles()));
            } else if (checkName(file, ext)) {
                result.add(file);
            }
        }
        return result;
    }

    private boolean checkName(File file, Set<String> set) {
        boolean result = true;
        for (String s : set) {
            if (file.getName().endsWith(s)) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Args arguments = new Args(args);
        Zip zip = new Zip();
        List<File> listToZip = zip.seekBy(arguments.getDirectory(), arguments.getExcule());
        zip.pack(listToZip, new File(arguments.getOutput()));
    }
}
