package com.seleniummaster.datastructure;

public class TwoDemensionArray {
    public static void main(String[] args) {
        String[][] seats=new String[][]{{"A1","A2","A3","A4","A5"},
                {"B1","B2","B3","B4","b5"},
                {"C1","C2","C3","C4","C5"}};
        int totalRows=3;
        int totalSeats=5;
        for(int i=0;i<totalRows;i++)
        {
            for(int j=0;j<totalSeats;j++)
            {
                System.out.println(String.format("row %d col %d Seat Row %s value %s",i,j,
                        seats[i][j].substring(0,1),seats[i][j]));
            }
        }
    }
}
