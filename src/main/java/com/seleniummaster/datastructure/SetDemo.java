package com.seleniummaster.datastructure;

import java.util.*;

public class SetDemo {
    public static void main(String[] args) {
        //create a set with multple states in the USA and print them
        Set<String> states = new HashSet<String>();
        states.add("Maryland");
        states.add("Virginia");
        states.add("Ohio");
        states.add("New York");
        states.add("MA");
        //print all states
        System.out.println(states.toString());
        states.add("Maryland");
        System.out.println(states.toString());

        Set<Integer> numbers = new HashSet<Integer>();
        numbers.add(10);
        numbers.add(4);
        numbers.add(25);
        System.out.println(numbers);
        //use Iterator to print each value in the set
        Iterator<String > itorator= states.iterator();
        while (itorator.hasNext()) {
            System.out.println(itorator.next());
        }
        //using for loop;
        Object[] temp=states.toArray();
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i]+" ");
        }
        //for each loop
        System.out.println();
        for (String s : states) {
            System.out.print(s+" ");
        }

    }
}
