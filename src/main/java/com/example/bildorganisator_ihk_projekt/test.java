package com.example.bildorganisator_ihk_projekt;

import java.io.IOException;

import static com.example.bildorganisator_ihk_projekt.RequestLink.getLocation;

public class test {
    public static void main(String[] args) throws IOException {
        new RequestLink();
        String longitude ="51.514244"; // N
        // if the coordinates are S, add - before the longitude number
        String latitude ="7.468429";  // E
        // if the coordinates are W, add - before the latitude number
        getLocation(longitude,latitude);
    }
}
