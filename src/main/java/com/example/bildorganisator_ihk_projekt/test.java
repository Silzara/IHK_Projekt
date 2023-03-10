package com.example.bildorganisator_ihk_projekt;

import com.drew.imaging.ImageProcessingException;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) throws IOException, ImageProcessingException {
        //new RequestLink();
        //String longitude ="51.514244"; // N
        // if the longitude coordinates are S, add - before the number
        //String latitude ="7.468429";  // E
        // if the latitude coordinates are W, add - before the number
        //getLocation(longitude,latitude);

        Browse test = new Browse();
        String test4 = test.selectFolder(); //
        ArrayList test3 = new ArrayList();
        GetImagesFromFolder astra = new GetImagesFromFolder(test4);
        astra.GetImagesFromFolders((Path) test,test3);
        System.out.println(astra);

    }
}

