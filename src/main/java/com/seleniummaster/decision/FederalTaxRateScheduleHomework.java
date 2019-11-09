package com.seleniummaster.decision;

import java.util.Scanner;

/**
 * this is a home work of week13-1, and this is a code written by sheba..
 */

public class FederalTaxRateScheduleHomework {
    public static void main(String[] args) {
        final double Rate1 = .10;//interest rate
        final double Rate2 = .25;

        final double S1_incomebracket = 32000;//income bracket
        final double M1_incomebracket = 64000;

        double tax1 = 0;
        double tax2 = 0;
        //enter income
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your income");
        double income = in.nextDouble();

        //enter marital status
        System.out.println("Enter Marital Status,S o M");
        String maritalstatus = in.next();
        if (maritalstatus.equals("S")) {
            if (income <= S1_incomebracket) {
                tax1 = Rate1 * income;
            } else {
                tax1 = Rate1 * S1_incomebracket;
                tax2 = Rate2 * (income - S1_incomebracket);
            }
        } else {
            if (income <= M1_incomebracket) {
                tax1 = Rate1 * income;
            } else
                tax1 = Rate1 * M1_incomebracket;
            tax2 = Rate2 * (income - M1_incomebracket);
        }

        double totalTax = tax1 + tax2;
        System.out.println("Tax will be $ " + totalTax);
    }
}
