package com.example.bildorganisator_ihk_projekt;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestLink {
    public static void main(String[] args) throws IOException {
        String a ="51.514244";
        String b ="7.468429";
        getLocation(a,b);
    }

    public static void getLocation(String latitude, String longitude) throws IOException {
        //Instantiating the URL class
        URL url = new URL("https://nominatim.openstreetmap.org/reverse?format=xml&" +
                "lat=" + latitude +
                "&lon=" + longitude
                + "&zoom=8&addressdetails=1");
        //Retrieving the contents of the specified page
        Scanner gl = new Scanner(url.openStream());
        //Instantiating the StringBuffer class to hold the result
        StringBuffer dp = new StringBuffer();
        while (gl.hasNext()) {
            dp.append(gl.next());
            //System.out.println(sc.next());
        }
        //Retrieving the String from the String Buffer object
        String result = dp.toString();
        //System.out.println(result);
        //Removing the HTML tags
        //result = result.replaceAll("<[^>]*>", "");
        //System.out.println("Contents of the web page: " + result);
        Pattern city = Pattern.compile("<city>(.*?)</city");
        Pattern state = Pattern.compile("<state>(.*?)</state>");
        Pattern country = Pattern.compile("<country>(.*?)</country>");
        Matcher cityMatcher = city.matcher(result);
        if(cityMatcher.find()) System.out.println(cityMatcher.group(1));
        Matcher stateMatcher = state.matcher(result);
        if(stateMatcher.find()) System.out.println(stateMatcher.group(1));
        Matcher countryMatcher = country.matcher(result);
        if(countryMatcher.find()) System.out.println(countryMatcher.group(1));

       // System.out.println(city);
    }

}

