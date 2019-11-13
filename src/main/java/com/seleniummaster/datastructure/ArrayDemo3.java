package com.seleniummaster.datastructure;

public class ArrayDemo3 {
    public static void main(String[] args) {
        String[] websites= new String[4];
        websites[0]="http://www.google.com";
        websites[1]="http://www.yahoo.com";
        websites[2]="http://www.cnn.com";
        websites[3]="http://www.youtube.com";
        //print each element un the array
        for(String website:websites)
        {
            System.out.println(website);
        }


        String[] keywords=new String[]{
                "Selenium","Java","Pyhon",
                "Washington DC", "New York", "1234"};
        //print keywords
        for(String keyword:keywords)
            System.out.println(keyword);

        }
    }


