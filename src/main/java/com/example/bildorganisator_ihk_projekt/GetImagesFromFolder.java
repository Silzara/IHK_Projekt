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
        ArrayList<String> photoList = new ArrayList<String>();
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
                photoList.add(tmpF.getAbsolutePath());
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

    public ArrayList GetImagesFromFolders(Path path, ArrayList result) {

        Stack<File> s = new Stack<>();
        s.push(path.toFile());
        // initially stack is not empty
        System.out.println("The images found inside the folder are: ");
        while (!s.empty()) {
            File tmpF = s.pop();
            // check if it is a file or not
            if (tmpF.isFile() && tmpF.getName().endsWith(".jpg") || tmpF.getName().endsWith(".png")) {
                // print file name can code here according
                // to our need
                //System.out.println(tmpF.getAbsolutePath());
                result.add(tmpF.getAbsolutePath());
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
        System.out.println(result);
        return result;
    }
}
