package com.example.bildorganisator_ihk_projekt;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Stack;

public class GetImagesFromFolder {

    /**
     This class represents a method for retrieving all image files with the extensions ".jpg" or ".png" from a given directory path and its subdirectories.
     */
    /**
     * Constructs an object of GetImagesFromFolder with the given path.
     *
     * @param path the path of the directory to search for image files.
     */
    public GetImagesFromFolder(String path) {
        File file = new File(path);
        Stack<File> s = new Stack<>();
        s.push(file);
        // initially stack is not empty
        System.out.println("The images found inside the folder are: ");
        while (!s.empty()) {
            File tmpF = s.pop();
            // check if it is a file or not
            if (tmpF.isFile() && tmpF.getName().endsWith(".jpg") || tmpF.getName().endsWith(".png")) {
                // print file name can code here according
                // to our need
                System.out.println(tmpF.getAbsolutePath());
            } else if (tmpF.isDirectory()) {
                // It's a directory hence list and push all
                // files in stack
                File[] f = tmpF.listFiles();
                for (File fpp : f) {
                    s.push(fpp);
                }
            }
            //System.out.println(photoList);// else if ends here

        }
    }

    /**
     This class provides a method for recursively finding all image files (.jpg and .png) within a specified directory and its subdirectories.
     The method takes a Path object representing the directory to search and an ArrayList object to store the paths of the image files found.
     The method uses a stack-based depth-first search algorithm to traverse the directory tree and identify all image files.
     The paths of the image files found are added to the specified ArrayList.

     @param path the Path object representing the directory to search for image files

     @param result the ArrayList object to store the paths of the image files found

     @return the ArrayList object containing the paths of the image files found
     */
    public ArrayList GetImagesFromFolders(Path path, ArrayList result) {

        // Create a stack to store directories and files to be searched
        Stack<File> s = new Stack<>();

        // Add the specified directory to the stack
        s.push(path.toFile());

        // Print a message indicating that the image search has begun
        System.out.println("The images found inside the folder are: ");

        // Traverse the directory tree using a stack-based depth-first search algorithm
        while (!s.empty()) {
        // Pop the top element from the stack
            File tmpF = s.pop();
            // Check if the popped element is a file with an image extension (.jpg or .png)
            if (tmpF.isFile() && tmpF.getName().endsWith(".jpg") || tmpF.getName().endsWith(".png")) {
                // If it is, add its path to the ArrayList
                result.add(tmpF.getAbsolutePath());
                // If the popped element is a directory, list all its files and add them to the stack
            } else if (tmpF.isDirectory()) {
                // It's a directory hence list and push all
                // files in stack
                File[] f = tmpF.listFiles();
                for (File fpp : f) {
                    s.push(fpp);
                }
            }
        }
        // Return the ArrayList containing the paths of the image files found
        return result;
    }
}
