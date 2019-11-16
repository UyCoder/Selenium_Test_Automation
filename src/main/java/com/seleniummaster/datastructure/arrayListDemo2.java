package com.seleniummaster.datastructure;

import java.util.ArrayList;
import java.util.List;

public class arrayListDemo2 {
    public static void main(String[] args) {
        List<String> names=new ArrayList<String>();
        names.add("Mike");
        names.add("Maria");
        names.add("Alex");
        names.add("Chris");
        for(int i=0; i<names.size(); i++){
            System.out.print(names.get(i) + "\t");
        }
        System.out.println();
        names.add(1,"Dolkun");
        for(String name:names){
            System.out.print(name+"\t");
        }
        System.out.println();
        names.set(1, "Tarim");
        System.out.println(names.toString());
        names.remove(1);
        System.out.println(names.toString());
        System.out.println(names.contains("Mike"));
    }
}
