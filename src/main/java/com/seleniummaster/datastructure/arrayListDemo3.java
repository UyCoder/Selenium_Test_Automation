package com.seleniummaster.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class arrayListDemo3 {
    public static void main(String[] args) {
        int[] evenNumbers = new int[]{2, 4, 6, 8, 10, 12};
        List<Integer> numberList = new ArrayList<Integer>();
        for (int n : evenNumbers) {
            numberList.add(n);
        }
        System.out.println(numberList.toString());
        numberList.add(14);
        System.out.println(numberList.toString());

        //define a new list
        List<Integer> numbers2=new ArrayList<Integer>();
        Integer[] evenNumber2=new Integer[]{2,4,6,8,10};
        numbers2= Arrays.asList(evenNumber2);
        System.out.println(numbers2);
    }
}
