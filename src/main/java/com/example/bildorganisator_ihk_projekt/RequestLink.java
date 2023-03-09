package com.example.bildorganisator_ihk_projekt;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestLink {
    @Override
    public String toString() {
        return "RequestLink{}";
    }

    public RequestLink() {
    }

    public static void main(String[] args) {
//        String a ="51.514244";
//        String b ="7.468429";
//        getLocation(a,b);
    }

    /**
     * Retrieves the location details for the given latitude and longitude using the OpenStreetMap Nominatim API.
     * <p>
     * The API returns the XML response which is then parsed to extract the city, state and country information.
     *
     * @param latitude  The latitude coordinate for the location.
     * @param longitude The longitude coordinate for the location.
     * @throws IOException If an I/O error occurs while reading from the URL connection.
     */
    public static void getLocation(String latitude, String longitude) throws IOException {
//Instantiating the URL class
        URL url = new URL("https://nominatim.openstreetmap.org/reverse?format=xml&" +
                "lat=" + latitude +
                "&lon=" + longitude
                + "&zoom=8&addressdetails=1");

//Retrieving the contents of the specified page
        Scanner gl = new Scanner(url.openStream());

//Instantiating the StringBuilder class to hold the result
        StringBuilder dp = new StringBuilder();
        while (gl.hasNext()) {
            dp.append(gl.next());
        }

//Retrieving the String from the StringBuilder object
        String result = dp.toString();

//Extracting city, state and country information from the XML response
        Pattern city = Pattern.compile("<city>(.*?)</city");
        Matcher cityMatcher = city.matcher(result);
        if (cityMatcher.find()) System.out.println(cityMatcher.group(1));

        Pattern state = Pattern.compile("<state>(.*?)</state>");
        Matcher stateMatcher = state.matcher(result);
        if (stateMatcher.find()) System.out.println(stateMatcher.group(1));

        Pattern country = Pattern.compile("<country>(.*?)</country>");
        Matcher countryMatcher = country.matcher(result);
        if (countryMatcher.find()) System.out.println(countryMatcher.group(1));
    }

}

