package com.example.bildorganisator_ihk_projekt;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * This class provides a method for finding all image files (.jpg and .png) within a selected directory and its subdirectories.
 * <p>
 * The method prompts the user to select a directory using a file chooser dialog box and then searches for all image files within the selected directory and its subdirectories.
 * <p>
 * The method prints the path of each image file found to the console.
 */
public class Find {

    /**
     * Searches for all image files (.jpg and .png) within a selected directory and its subdirectories.
     * <p>
     * The method prompts the user to select a directory using a file chooser dialog box and then searches for all image files within the selected directory and its subdirectories.
     * <p>
     * The method prints the path of each image file found to the console.
     *
     * @throws IOException if an I/O error occurs during the file search
     */
    public Find() throws IOException {
      // Prompt user to select a directory using a file chooser dialog box
        Path search = Path.of(Browse.selectFolder());
      // Search for all image files (.jpg and .png) within the selected directory and its subdirectories
        Stream<Path> stream =
                Files.find(search, 100,
                        (path, basicFileAttributes) -> {
                            File file = path.toFile();
                            return !file.isDirectory() &&
                                    file.getName().contains(".jpg") || file.getName().contains(".png");
                        });
      // Print the path of each image file found to the console
        stream.forEach(System.out::println);
    }
}