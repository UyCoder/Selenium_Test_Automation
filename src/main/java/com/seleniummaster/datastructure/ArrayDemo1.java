package com.seleniummaster.datastructure;

public class ArrayDemo1 {
    //define
    //assign value
    //print array elements
    //get total count of elements in array
    public static void main(String[] args) {
        //define an integer array
        int[] numbers = new int[5];
        numbers[0] = 150;
        numbers[1] = 200;
        numbers[3] = 500;

        int totalNumbers = numbers.length;// this returns total elements of array
        for (int i = 0; i < totalNumbers; i++) {
            System.out.print(numbers[i] + ", ");
        }
    }
}
