package com.example.bildorganisator_ihk_projekt;

import java.io.File;
import java.io.IOException;
import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

public class ReadMetaData {
    public ReadMetaData(File file) throws ImageProcessingException, IOException {
        // Read the metadata from the image file
        Metadata metadata = ImageMetadataReader.readMetadata(file);
        // Print a header for the metadata information
        System.out.println("\n" + "Start of Metadata from image: " + file.getName());
        // Iterate over all directories in the metadata and print their tags and values
        for (Directory directory : metadata.getDirectories()) {
            for (Tag tag : directory.getTags()) {
                System.out.format("[%s] - %s = %s",
                        // getName() for structure
                        // getTagName() for structure elements
                        // getDescription() for elements data information
                        directory.getName(), tag.getTagName(), tag.getDescription() + "\n");
            }
            // If there are errors in the directory, print them to the console
            if (directory.hasErrors()) {
                for (String error : directory.getErrors()) {
                    System.err.format("ERROR: %s", error);
                }
            }
        }
    }

    public static void main(String[] args) throws ImageProcessingException, IOException {
        File john = new File("C:\\Users\\pappd\\Digi Storage folder\\Binarium\\test\\testChristian.jpg");
        ReadMetaData xxx = new ReadMetaData(john);
        System.out.println(xxx);
    }
}
