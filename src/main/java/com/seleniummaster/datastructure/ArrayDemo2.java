package com.seleniummaster.datastructure;

public class ArrayDemo2 {
    public static void main(String[] args) {
        //define an array with some initial value
        int[] myNumbers = new int[]{2, 5, 10, 30, 100, 150, 6, 5};
        //how many numbers??
        // System.out.println(myNumbers.length);
        int totalCount = myNumbers.length;
        System.out.println("Total number of the string: " + totalCount);
        //print out 3rd number
        System.out.println(myNumbers[2]);
        //print out each element of the array
        //using for each loop
        for (int x : myNumbers) {
            System.out.print(x + ", ");
            //System.out.print(String.format("%d, ",x));
        }
        System.out.println();
        //use for loop to print each member of the array
        for (int i = 0; i < totalCount; i++) {
            System.out.print(myNumbers[i] + ", ");
        }

    }
}
