package com.seleniummaster.io;

public class StringBuilderDemo_PrerecordingVideo {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("This is String builder example").append("\n");
        stringBuilder.append("line a ").append("\n");
        stringBuilder.append("line b ").append("\n");
        System.out.println(stringBuilder.toString());
        int[] myNumbers = new int[]{10, 15, 13, 14, 52, 60, 35, 70};
        for (int i : myNumbers) {
            stringBuilder.append(i).append("\n");
        }
        System.out.println(stringBuilder.toString());

    }
}
