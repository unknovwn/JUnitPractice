package com.example.file;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileWriter {

    private FileWriter() {}

    /**
     * Creates empty file in given path
     * @param path Path where the file will be created
     */
    public static void createFile(Path path) {
        try {
            Files.writeString(path, "", StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Appends given string into a file
     * @param path Path to a file into which string will be appended
     * @param content String to append
     */
    public static void appendFile(Path path, String content) throws IOException {
        Files.writeString(path, content, StandardOpenOption.APPEND);
    }
}
