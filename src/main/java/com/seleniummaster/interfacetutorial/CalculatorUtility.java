package com.seleniummaster.interfacetutorial;

import org.openqa.selenium.json.JsonOutput;

public class CalculatorUtility {
    public static void main(String[] args) {
        System.out.println("Version of Simple Calculator: "+ ISimpleCalculator.Version);
        ISimpleCalculator simpleCalculator=new Calculator();
        simpleCalculator.addTwoNumber(10, 25);
        simpleCalculator.divideTwoNumber(30, 4);
        simpleCalculator.multiplyTwoNumber(10, 15);
        simpleCalculator.subTrackTwoNumber(1000, 800);

        //use scientific calculator
        System.out.println("\nVersion of Scientific calcuator: "+IScientificCalculator.version);
        IScientificCalculator scientificCalculator=new Calculator();
        scientificCalculator.calculateAbstractValvue(-10);
        scientificCalculator.calculatePower(10,2);
        scientificCalculator.calculateSquareRoor(9);
    }
}
