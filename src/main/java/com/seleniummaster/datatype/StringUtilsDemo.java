package com.seleniummaster.datatype;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

public class StringUtilsDemo {
    public static void main(String[] args) {
        String s1="learning Java is fun";
        String s2="12349087";
        String s3="";

        //convert cases
        System.out.println(StringUtils.capitalize(s1));
        System.out.println(StringUtils.swapCase(s1));
        System.out.println(org.metawidget.util.simple.StringUtils.camelCase(s1));
        s1= org.metawidget.util.simple.StringUtils.uppercaseFirstLetter(s1);
        System.out.println(WordUtils.capitalize(s1));

        //verify if string is empty
        System.out.println(StringUtils.isEmpty(s3));
        System.out.println(StringUtils.isEmpty(s2));

        //reverse the string
        System.out.println(StringUtils.reverse(s1));


    }
}
