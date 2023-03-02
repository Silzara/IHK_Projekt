package com.example.bildorganisator_ihk_projekt;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Stack;

public class Browse {
    /**
     * This method creates a GUI interface that allows the user to select a folder. It uses a JFileChooser object to accomplish this.
     *
     * @return A String representation of the path to the selected folder.
     */
    public static String selectFolder() {
      // create a new JFileChooser object
        JFileChooser folderChooser = new JFileChooser();
      // set the current directory of the file chooser to the current working directory
        folderChooser.setCurrentDirectory(new java.io.File("."));
      // set the title of the file chooser window
        folderChooser.setDialogTitle("Browse");
      // set the file selection mode to select only directories
        folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      // disable the "All Files" filter option
        folderChooser.setAcceptAllFileFilterUsed(false);
      // if the user selects a folder, get the path to the folder as a String
        if (folderChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
      // uncomment the following lines to print the selected folder path to the console
      //System.out.println("getCurrentDirectory(): " + folderChooser.getCurrentDirectory());
      //System.out.println("getSelectedFile(): " + folderChooser.getSelectedFile());
        } else {
      // if the user cancels the file selection, print a message to the console
            System.out.println("No Selection ");
        }
        String pathToFolder = String.valueOf(folderChooser.getSelectedFile());
      // print the path of the selected folder to the console
        System.out.println("Browser path:");
        System.out.println(pathToFolder);
      // return the path of the selected folder as a String
        return pathToFolder;
    }
}
