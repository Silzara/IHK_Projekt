package com.example.bildorganisator_ihk_projekt;

import javax.swing.*;
import java.awt.event.*;

import java.nio.file.Path;
import java.util.*;

public class Selector {
    public static class DemoJFileChooser extends JPanel implements ActionListener {
        JButton go;

        JFileChooser chooser;
        String choosertitle;

        public DemoJFileChooser() {
            go = new JButton("Do it");
            go.addActionListener(this);
            add(go);
        }

        public void actionPerformed(ActionEvent e) {
            chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle(choosertitle);
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            //
            // disable the "All files" option.
            //
            chooser.setAcceptAllFileFilterUsed(false);
            //
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                System.out.println("getCurrentDirectory(): "
                        + chooser.getCurrentDirectory());
                System.out.println("getSelectedFile() : "
                        + chooser.getSelectedFile());
            }
        }
    }

    public static void main(String[] args) {

        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        f.showSaveDialog(null);
        System.out.println(f.getCurrentDirectory().getAbsolutePath());

       // System.out.println(f.getCurrentDirectory());
        //System.out.println(f.getSelectedFile());

//        GetImagesFromFolder alo = new GetImagesFromFolder(f.getSelectedFile().toString());
//        Path ttt = Path.of(f.getSelectedFile().toString());
//        ArrayList aloAL = new ArrayList<>();
//        alo.GetImagesFromFolders(ttt,aloAL);
//        //System.out.println("ArrayList is:");
//        System.out.println(aloAL.get(3));

    }
}