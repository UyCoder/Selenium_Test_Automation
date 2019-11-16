package com.seleniummaster.datastructure;

import java.util.ArrayList;
import java.util.List;

public class arrayListDemo {
    //define a list that will contain few numbers and the print them
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(50);
        numbers.add(125);
        numbers.add(33);
        numbers.add(45);
        numbers.add(500);
        // let's find the avarage of all numbers
        int totlaCount = numbers.size();
        int sum = 0;
        for (int n : numbers) {
            sum = sum + n;
            System.out.println(String.format("i=%d \t sum=%d", n, sum));
        }
        double avarage = (double) sum / totlaCount;
        System.out.println(String.format("Avarage \t %.2f", avarage));
    }
}
