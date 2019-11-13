package com.seleniummaster.datastructure;

import java.util.Arrays;

public class ArrayDemo4 {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 10, 4, 20, 15, 30, 56, 78, 90, 95};
        System.out.println(Arrays.toString(numbers));
        for (int i : numbers) {
            System.out.print(i + " ");
        }
        System.out.println();
        //sort the array numbers from small to big
        Arrays.sort(numbers);
        for (int j : numbers) {
            System.out.print(j + " ");
        }
        System.out.println();
        //if we want to print large to small
        // we can print backwards
        System.out.println();
        for(int i=numbers.length-1;i>=0;i--) {
            System.out.print(numbers[i] + " ");
        }
    }
}
