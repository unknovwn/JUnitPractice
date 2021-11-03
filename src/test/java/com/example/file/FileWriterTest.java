package com.example.file;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class FileWriterTest {

    @Test
    @DisplayName("Path given by the @TempDir annotation is writable")
    void pathFromTempDirIsWritable(@TempDir Path path) {
        assertTrue(Files.isWritable(path));
    }

    @Test
    @DisplayName("Appending to a file which has not yet been created throw an exception")
    void nonExistingFileThrowsAnException(@TempDir Path path) {
        Path file = path.resolve("content.txt");
        assertThrows(IOException.class, () -> FileWriter.appendFile(file, "hello"));
    }

    @Test
    @DisplayName("Appending works on created file")
    void appendingWorks(@TempDir Path path) throws IOException {
        Path file = path.resolve("content.txt");
        FileWriter.createFile(file);
        FileWriter.appendFile(file, "hello");
        assertTrue(Files.isReadable(file));
        assertEquals("hello", Files.readString(file));
    }
}