package com.seleniummaster.datastructure;

import java.util.*;

public class MapDemo {
    public static void main(String[] args) {
        //define a amp for websites
        // google (key) - www.google.com (value)
        // yahoo (key) - www.yahoo.com (value)
        // youtube (key) - www.youtube.com (value)
        // cnn (key) - www.cnn.com (value)
        Map<String, String> website = new HashMap<String, String>();
        website.put("Google", "https://www.google.com");
        website.put("Yahoo", "https://www.yahoo.com");
        website.put("CNN", "https://www.cnn.com");
        website.put("Youtube", "https://www.youtube.com");
        //read value from key
        System.out.println(website.get("Google"));
        //read all values one by one
        Set<String> sites = website.keySet();//get all keys
        for (String s : sites) {
            System.out.println(website.get(s));// read each value
        }
        //replace key and value in a map
        website.replace("CNN", "https://www.cnn.com", "http://cnn.com");
        List<String> keys = new ArrayList<String>(website.keySet());
        for (String key : keys) {
            System.out.println(website.get(key));
        }
        System.out.println(website.containsKey("Google"));
        System.out.println(website.containsValue("http://www.cnn.com"));
    }
}
